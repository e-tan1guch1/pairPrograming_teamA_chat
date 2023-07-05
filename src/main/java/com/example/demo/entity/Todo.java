package com.example.demo.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
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
	private Integer id;
	@Column(name="releasedate")
	private LocalDate releaseDate;
	private Integer hour;
	private Integer minute;
	private String text; // 内容
	@Column(name="user_id")
	private Integer userId;
	private boolean checked;

	public Todo() {
		
	}
	
	public Todo(LocalDate releaseDate,Integer hour, Integer minute,String text,Integer userId,boolean checked) {
		this.releaseDate = releaseDate;
		this.hour = hour;
		this.minute = minute;
		this.text = text;
		this.userId = userId;
		this.checked = false;
//		this.date = date;
	}

	public Todo(Integer id, LocalDate releaseDate, Integer hour, Integer minute, String text,Integer userId,boolean checked) {
		this.id = id;
		this.releaseDate = releaseDate;
		this.hour = hour;
		this.minute = minute;
		this.text = text;
		this.userId = userId;
		this.checked = false;
//		this.date =date;
	}
	
	

}
