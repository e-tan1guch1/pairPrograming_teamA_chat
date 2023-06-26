package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.model.Display;
import com.example.demo.repository.ChatRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	Account account;

	@Autowired
	ChatRepository chatRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/chat")
	public String chat(
			Model m) {

		// チャット内容の全件検索
		List<Chat> chats = chatRepository.findAll();
		List<Display> displays = new ArrayList<>();
		List<User> addressList = userRepository.findAll();

		for (Chat chat : chats) {
			int userId = chat.getId();
			Optional<User> opt = userRepository.findById(userId);
			displays.add(new Display(opt.get().getName(), chat.getText()));
		}
		m.addAttribute("chats", displays);
		m.addAttribute("addressList", addressList);

		return "Chat";
	}
	
	@PostMapping("/chat/add")
	public String add(
			Model m,
			@RequestParam(name="text", defaultValue="")String text,
			@RequestParam(name="address", defaultValue="")Integer addressId
			) {
		
		LocalDateTime timeNow = LocalDateTime.now();
		
		chatRepository.save(new Chat(account.getId(), text, addressId, timeNow));
		
		return "redirect:/chat";
	}

}
