package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.UserRepository;

@Controller
public class LoginController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/login")
	public String index() {
		return "Login";
	}

	@PostMapping("/login")
	public String login(Model model,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password) {
		
		String page = "";
		Optional<User>result = userRepository.findByEmailAndPassword(email,password);
		
		User u = null;
		if(result.isPresent()) {
			u= result.get();
			page = "";
		} else {
			page = "Login";
		}
		
		return page;
	}
}
