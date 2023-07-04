package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // ユーザID
	
	private String icon; // iconのURL

	private String name; // ユーザネーム

	private String email; // メールアドレス

	private String password; // パスワード
	
	
	 public boolean isFriend() {
		 
		 return false;
	 }
	
	User(){
		
	}

	public User(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(Integer id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	
	

}
