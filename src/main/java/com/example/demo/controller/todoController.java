package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		List<Todo> todos = todoRepository.findAll();
		m.addAttribute("todos",todos);
		
		
		return "todoList";
	}
	

	@GetMapping("/todolist/newtodo")
	public String index() {
		return "todo";
	}

	@PostMapping("/todolist/newtodo")
	public String todo(Model m,
			@RequestParam(name = "releaseDate", defaultValue = "") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text) {

		Todo todos = new Todo(releaseDate,hour, minute, text);
		todoRepository.save(todos);

		return "redirect:/todoList";
	}
	
	@GetMapping("/todoList/{id}/edit")
	public String edit(
			@PathVariable("id")Integer id,
			Model m) {
		Todo todo = todoRepository.findById(id).get();
		m.addAttribute("todo", todo);

		return "edit";
	}
	
	@PostMapping("/todoList/{id}/edit")
	public String edit(
			@PathVariable("id") Integer id,
			@RequestParam(name = "releaseDate", defaultValue = "") 
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "hour", required = false) Integer hour,
			@RequestParam(name = "minute", required = false) Integer minute,
			@RequestParam(name = "text", required = false) String text,
			Model m) {
		Todo todos = new Todo(id, releaseDate,hour, minute, text);
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
	

}
