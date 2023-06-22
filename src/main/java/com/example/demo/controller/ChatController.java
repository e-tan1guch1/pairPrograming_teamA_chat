package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import com.example.demo.model.Display;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ChatController {

	@Autowired
	ChatRepository chatRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/chat")
	public String chat(
			Model m) {

		List<Chat> chats = chatRepository.findAll();
		List<Display> displays = new ArrayList<>();

		for (Chat chat : chats) {
			int userId = chat.getId();
			Optional<User> opt = userRepository.findById(userId);
			displays.add(new Display(opt.get().getName(), chat.getText()));
		}
		m.addAttribute("chats", displays);

		return "Chat";
	}
	
	@GetMapping("/chat/add")
	public String add() {
		return "";
	}

}
