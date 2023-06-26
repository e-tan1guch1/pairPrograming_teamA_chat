package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Todo;
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
	
	@GetMapping("/chat/todo")
	public String index() {
		return "todo";
	}

	@PostMapping("/chat/todo")
	public String todo(Model m,
			@RequestParam(name = "releaseDate", required = false)
			@DateTimeFormat(pattern ="yyyy-MM-dd") LocalDate releaseDate,
			@RequestParam(name = "text", required = false) String text
			) {
		
		m.addAttribute("text",text);
		m.addAttribute("releaseDate", releaseDate);

		
		return "";
	}
	@GetMapping("/chat/diary")
	public String diary() {
		session.invalidate();
		return "diary";
	}
	
	
}
