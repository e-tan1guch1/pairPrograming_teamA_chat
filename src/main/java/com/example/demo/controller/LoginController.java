package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Icon;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.IconRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	IconRepository iconRepository;

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
			Icon icon = iconRepository.findById(u.getIconId()).get();
			account.setIcon(icon.getIconUrl());
		} else {
			page = "Login";
		}

		List<String> errors = new ArrayList<>();
		if (email.equals("") == true || email.length() == 0) {
			errors.add("e-mailを入力してください");
		} else {
			if (password.equals("") != true || password.length() != 0) {
				Optional<User> record = userRepository.findByEmailAndPassword(email, password);
				if (record.isEmpty() == true) {
					errors.add("メールアドレスとパスワードが違います");
				}
			}

		}
		if (password.equals("") == true || password.length() == 0) {
			errors.add("パスワードを入力してください");
		}

		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("email", email);
			model.addAttribute("password", password);
		}

		return page;
	}

	@GetMapping("/login/newuser")
	public String newuser(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password,

			Model m) {

		m.addAttribute("name", name);
		m.addAttribute("email", email);
		m.addAttribute("password", password);
		return "newuser";
	}

	@PostMapping("/login/newuser")
	public String newuser(Model m,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "password", required = false) String password) {
		List<String> error = new ArrayList<>();

		if (name.equals("") == true) {
			error.add("名前は必須です");

		}
		if (name.length() > 9) {
			error.add("名前は9文字以内です");
		}

		if (email.equals("") == true) {
			error.add("メールアドレスは必須です");

		} else {
			Optional<User> opt = userRepository.findByEmail(email);
			if (opt.isPresent()) {
				error.add("登録済みのメールアドレスです");
			}
			
			if(!isMailAddress(email)) {
				error.add("メールアドレスを入力してください");
			}
		}

		if (password.equals("") == true) {
			error.add("パスワードは必須です");
		}

		if (error.size() > 0) {

			m.addAttribute("error", error);
			m.addAttribute("name", name);
			m.addAttribute("email", email);
			m.addAttribute("password", password);
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
			m.addAttribute("password", password);
			return "newuser";
		}

		User user = new User(1, name, email, password);
		userRepository.save(user);
		m.addAttribute("user", user);

		return "Login2";
	}
	

	// メールアドレスかどうかを判定
	public static boolean isMailAddress(String value) {
		boolean result = false;
		if (value != null) {
			Pattern pattern = Pattern.compile("^([a-zA-Z0-9])+([a-zA-Z0-9._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9._-]+)+$");
			result = pattern.matcher(value).matches();
		}
		return result;
	}

}
