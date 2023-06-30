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

	@GetMapping({ "/login", "/logout" })
	public String index(
			
			Model m) {
		
		session.invalidate();
		
		return "Login";
	}

	@PostMapping("/login")
	public String login(Model model,
			@RequestParam(name = "error", defaultValue = "") String error,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password) {

		String page = "";
		Optional<User> result = userRepository.findByEmailAndPassword(email, password);

		User u = null;
		if (result.isPresent()) {
			u = result.get();
			page = "redirect:/chat";
			account.setId(u.getId());
			account.setName(u.getName());
		} else {
			page = "Login";
		}
		
		List<String> errors = new ArrayList<>();
		if (email.equals("") == true || email.length() == 0) {
			errors.add( "e-mailを入力してください");
		}
		if (password.equals("") == true || password.length() == 0) {
			errors.add("パスワードを入力してください");
		}
		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("email", email);
			model.addAttribute("pasword", password);
		}
		

		return page;
	}

	@GetMapping("/login/newuser")
	public String newuser() {
		return "newuser";
	}

	@PostMapping("/login/newuser")
	public String newuser(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password,

			Model m) {
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
			return "newuser";
		}

		User user = new User(name, email, password);
		m.addAttribute("user", user);

		return "newuser2";
	}

	@PostMapping("/login/newuser2")
	public String newuser2(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password,

			Model m) {
		List<String> error = new ArrayList<>();

		Optional<User> opt = userRepository.findByEmail(email);
		if (opt.isPresent()) {
			error.add("登録済みのメールアドレスです");
		}

		if (error.size() > 0) {

			m.addAttribute("error", error);
			m.addAttribute("name", name);
			m.addAttribute("email", email);
			m.addAttribute("pasword", password);
			return "newuser";
		}

		User user = new User(name, email, password);
		userRepository.save(user);
		m.addAttribute("user", user);

		return "Login2";
	}

}
