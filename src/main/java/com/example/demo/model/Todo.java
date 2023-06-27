package com.example.demo.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Component
@Table(name = "todos")
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private LocalDate releaseDate;
	private Integer hour;
	private Integer minute;
	private String text; // 内容
	

	public Todo() {
		
	}
	
	public Todo(LocalDate releaseDate,Integer hour, Integer minute,String text) {
		this.releaseDate = releaseDate;
		this.hour = hour;
		this.minute = minute;
		this.text = text;
	}
	

}
