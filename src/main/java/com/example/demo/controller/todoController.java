package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Todo;
import com.example.demo.model.Account;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class todoController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	Todo todo;

	@Autowired
	TodoRepository todoRepository;

	@GetMapping("/todoList")
	public String list(Model m) {
		//		List<Todo> todos = todoRepository.findAll();
		//		m.addAttribute("todos",todos);

		//		Optional<Todo> opt = todoRepository.findById(account.getId());
		List<Todo> todo2 = todoRepository.findByUserIdOrderByReleaseDate(account.getId());

		//		for(Todo t : todo2) {
		//			System.err.println(t.getReleaseDate());
		//		}

		Todo todo = null;

		LocalDate tmp = LocalDate.of(1900, 1, 1);

		for (int i = 0; i < todo2.size(); i++) {
			Todo t = todo2.get(i);
			LocalDate date = t.getReleaseDate();

			if (date != null) { /*この行エラー対処のつもりで記述したけど不要かも*/
				if (!tmp.toString().equals(date.toString())) {
					Todo insert = new Todo(0, date, 0, 0, "", account.getId(), false);
					todo2.add(i, insert);

					tmp = date;
					System.err.println(tmp);
				}
			} /*この行エラー対処のつもりで記述したけど不要かも*/
		}

		for (Todo t : todo2) {
			System.err.println(t.getId() + " " + t.getReleaseDate());
		}
		//		if (todo2.size() ==0) {
		//			todo2 = null;
		//		}	
		//		List<Todo> list = todoRepository.findByReleaseDate(todo.getReleaseDate());
		
		m.addAttribute("todo2", todo2);
		
		List<String> demo = new ArrayList<>();
		
		if(todo2 != null) {
		demo.add("今日のTODOを確認しよう");
		demo.add("達成できたらチェックを入れてね");
		m.addAttribute("demo", demo);
		}
		
		return "todoList";
	}

	@GetMapping("/todolist/newtodo")
	public String index(
			@RequestParam(name = "releaseDate", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text,
			Model m) {

		m.addAttribute("releaseDate", releaseDate);
		m.addAttribute("hour", hour);
		m.addAttribute("minute", minute);
		m.addAttribute("text", text);

		return "todo";
	}

	@PostMapping("/todolist/newtodo")
	public String todo(Model m,
			@RequestParam(name = "releaseDate", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text) {

		List<String> error = new ArrayList<>();

		if (releaseDate == null) {
			error.add("日付は必須です");
		}

		if (text.equals("") == true) {
			error.add("本文は必須です");

		}

		if (error.size() > 0) {
			m.addAttribute("error", error);
			m.addAttribute("releaseDate", releaseDate);
			m.addAttribute("hour", hour);
			m.addAttribute("minute", minute);
			m.addAttribute("text", text);

			return "todo";
		}

		Todo todos = new Todo(releaseDate, hour, minute, text, account.getId(), false);
		todoRepository.save(todos);

		return "redirect:/todoList";
	}

	@GetMapping("/todoList/{id}/edit")
	public String edit(Model m,
			@PathVariable("id") Integer id,
			@RequestParam(name = "releaseDate", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text) {

		Todo todo = todoRepository.findById(id).get();
		m.addAttribute("todo", todo);

		//		m.addAttribute("todo.id",todo.getId());

		return "edit";
	}

	@PostMapping("/todoList/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			@RequestParam(name = "releaseDate", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text,
			Model m) {

		List<String> error = new ArrayList<>();

		if (releaseDate == null) {
			error.add("日付は必須です");
		}

		if (text.equals("") == true) {
			error.add("本文は必須です");

		}

		if (error.size() > 0) {
			//			m.addAttribute("error", error);
			m.addAttribute("releaseDate", releaseDate);
			m.addAttribute("hour", hour);
			m.addAttribute("minute", minute);
			m.addAttribute("text", text);

			return "redirect:/todoList/" + id + "/edit";
		}

		Todo todos = new Todo(id, releaseDate, hour, minute, text, account.getId(), false);
		todoRepository.save(todos);

		return "redirect:/todoList";
	}

	@PostMapping("/todoList/{id}/delete")
	public String delete(
			@PathVariable("id") Integer id,
			Model m) {
		todoRepository.deleteById(id);

		return "redirect:/todoList";
	}

	@GetMapping("/todoList/{id}/check")
	@ResponseBody
	public ResponseEntity<String> check(
			@PathVariable("id") Integer id,
			@RequestParam(name = "releaseDate", defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text,
			Model m) {

		Todo todo = todoRepository.findById(id).get();
		System.out.println("id;" + todo.getId()
				+ " text;" + todo.getText()
				+ " hour;" + todo.getHour()
				+ " minute;" + todo.getMinute()
				+ " checked;" + todo.isChecked()
				+ " releaseDate;" + todo.getReleaseDate());

		if (todo.isChecked() == false) {
			todo.setChecked(true);
		} else if(!todo.isChecked() == false) {
			todo.setChecked(false);
		}
		
		Todo todos = new Todo(todo.getId(), todo.getReleaseDate(), todo.getHour(), todo.getMinute(), todo.getText(),account.getId(), todo.isChecked());
		todoRepository.save(todos);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Connection", "Keep-Alive");
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<String>("text content", headers, status);
	}
}
