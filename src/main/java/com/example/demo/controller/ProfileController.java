package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	Account account;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/profile")
	public String profile(Model m) {
		
		User user = userRepository.findById(account.getId()).get();
		
		m.addAttribute("user", user);
		return "profile";
	}
	
	@PostMapping("/profile")
	public String profile2(Model m,
			@RequestParam(name="", defaultValue="")String name,
			@RequestParam(name="", defaultValue="")String email,
			@RequestParam(name="", defaultValue="")String password
			) {
		
		List<String> error = new ArrayList<>();
		
		if (name.equals("") == true) {
			error.add("名前は必須です");

		}
		if (email.equals("") == true) {
			error.add("メールアドレスは必須です");

		} else {
			Optional<User> opt = userRepository.findByEmail(email);
			if (opt.isPresent()) {
				error.add("登録済みのメールアドレスです");
			}
		}
		if (password.equals("") == true) {
			error.add("パスワードは必須です");
		}
		if (error.size() > 0) {

			m.addAttribute("error", error);
			m.addAttribute("name", name);
			m.addAttribute("email", email);
			m.addAttribute("pasword", password);
		}
		
		userRepository.save(new User(account.getId(), name, email, password));
		
		User user = userRepository.findById(account.getId()).get();
		
		m.addAttribute("user", user);
		return "profile";
	}

}
