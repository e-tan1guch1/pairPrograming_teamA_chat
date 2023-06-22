package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login")
	public String index() {
		return "Login";
	}

	@PostMapping("/login")
	public String login(Model model,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password) {
		return "";
	}
}
