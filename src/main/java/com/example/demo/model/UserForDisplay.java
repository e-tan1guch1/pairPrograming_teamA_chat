package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserForDisplay {
	
	private Integer id;
	private String name;
	private String email;
	private String iconUrl;
	
	public UserForDisplay() {

	}
	
	public UserForDisplay(Integer id, String name, String email,  String iconUrl) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.iconUrl = iconUrl;
	}
	
	

}
