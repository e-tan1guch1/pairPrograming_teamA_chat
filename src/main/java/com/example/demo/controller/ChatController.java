package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ChatController {
	@GetMapping("/chat")
	public String chat() {

		return "Chat";
	}

	@PostMapping("/chat")
	public String chat(
			@RequestParam("talk") String talk,
			Model m) {
//		Chat talklist = new Chat(talk);
//
//		.addDiary(talklist);
		
		return "redirect:/Chat";
	}

}
