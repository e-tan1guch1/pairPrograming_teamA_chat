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
@Table(name = "requests")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user2_id")
	private Integer user2Id;
	
	@Column(name="user_id")
	private Integer userId;
	
	public Request() {
	}

	public Request(Integer user2Id, Integer userId) {
		this.user2Id = user2Id;
		this.userId = userId;

	}
}
