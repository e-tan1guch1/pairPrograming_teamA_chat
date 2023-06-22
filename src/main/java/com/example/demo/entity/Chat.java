package com.example.demo.entity;

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
	private String addressId;
	
	private String date;
	
	Chat(){
		
	}
}
