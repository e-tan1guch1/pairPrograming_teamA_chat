package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class FriendController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/friends")
	public String index(Model m) {

		List<User> friends = userRepository.findAll();

		m.addAttribute("friends", friends);
		return "friends";
	}

	@GetMapping("/friends/add")
	public String add(Model m,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "search", defaultValue = "") String search

	) {
		if (!search.equals("")) {
			if (!email.equals("")) {
				Optional<User> opt = userRepository.findByEmail(email);
				if (opt.isPresent()) {
					m.addAttribute("friend", opt.get());
				}else {
					m.addAttribute("error", "そのアカウントは見つかりません");
				}
			}else {
				m.addAttribute("error", "メールアドレスを入力してください");
			}
		}

		return "addFriend";
	}

	@GetMapping("/friends/list")
	public String list(Model m) {
		return "friendRequestList";
	}

}
