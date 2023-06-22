package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Chat;
import com.example.demo.repository.ChatRepository;


@Controller
public class ChatController {
	
	@Autowired
	ChatRepository chatRepository;
	

	@GetMapping("/chat")
	public String chat(
			Model m) {
		
		List<Chat> chats = chatRepository.findAll();

		m.addAttribute("chats", chats);
		
		return "Chat";
	}

}
