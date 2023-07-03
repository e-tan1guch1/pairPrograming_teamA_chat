package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "chats")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // チャットID

	@Column(name = "user_id")
	private Integer userId; // ユーザid
	
	private String text; // テキスト
	
	@Column(name = "address_id")
	private Integer addressId;
	
	private LocalDateTime date;
	
	@Column(name = "like_button")
	private Integer likebutton;
	
	public Chat(){
		
	}

	public Chat(Integer userId, String text, Integer addressId, LocalDateTime date) {
		this.userId = userId;
		this.text = text;
		this.addressId = addressId;
		this.date = date;
	}
//	public Chat(Integer id,Integer userId, String text, Integer addressId, LocalDateTime date, Integer likebutton) {
//		this.id = id;
//		this.userId = userId;
//		this.text = text;
//		this.addressId = addressId;
//		this.date = date;
//		this.likebutton = likebutton;
//	}
}
