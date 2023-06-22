package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;


@Data
@Component
@SessionScope
public class Account {
	
	private int id; //ユーザID
	private String name; //ユーザ名

}
