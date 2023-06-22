package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Component
public class Display {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String name; // ユーザネーム

	private String text; // 内容
	
	public Display() {
		
	}

	public Display(String name, String text) {
		this.name = name;
		this.text = text;
	}

}
