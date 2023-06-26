package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Todo {

	
	private String releaseDate; // カレンダー

	private String text; // 内容
	
	public Todo() {
		
	}

	public Todo(String releaseDate, String text) {
		this.releaseDate = releaseDate;
		this.text = text;
	}

}
