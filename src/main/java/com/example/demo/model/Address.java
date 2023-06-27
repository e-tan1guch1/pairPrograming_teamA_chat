package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Address {
	
	private Integer id;
	private String name;
	private String email;
	
	public Address() {

	}
	
	public Address(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	

}
