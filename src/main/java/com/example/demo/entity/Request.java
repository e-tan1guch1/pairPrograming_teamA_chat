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
	
	@Column(name="reciever_id")
	private Integer recieverId;
	
	@Column(name="sender_id")
	private Integer senderId;
	
	public Request() {
	}

	public Request(Integer recieverId, Integer senderId) {
		this.recieverId = recieverId;
		this.senderId = senderId;

	}
}
