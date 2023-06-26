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
public class LoginController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	Account account;
	
	@GetMapping({"/login","/logout"})
	public String index() {
		session.invalidate();
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
			page = "redirect:/chat";
			account.setId(u.getId());
			account.setName(u.getName());
		} else {
			page = "Login";
		}
		
		return page;
	}
	@GetMapping("/login/newuser")
	public String newuser() {
		return "newuser";
	}
	@PostMapping("/login/newuser")
	public String newuser(
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password,
			
			Model m) {
		List<String> error = new ArrayList<>();
		
//		if (id.equals("") == true) {
//			error.add("id：必須");
//		}

		if (name.equals("") == true) {
			error.add("名前：必須");
	
		}
		if (email.equals("") == true) {
			error.add("メールアドレス：必須");

		}
		if (password.equals("") == true) {
			error.add("パスワード：必須");
		}
		if (error.size() > 0) {
			
			m.addAttribute("error", error);
//			m.addAttribute("id", id);
			m.addAttribute("name", name);
			m.addAttribute("email", email);
			m.addAttribute("pasword", password);
			return "newuser";
		}
		User user = new User(id, name, email, password);
		userRepository.save(user);
		
		return "redirect:/login";
	}
	
}
