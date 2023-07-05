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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // ユーザID
	
	@Column(name="icon_id")
	private Integer iconId; // iconのURL

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

	public User(Integer id, Integer iconId, String name, String email, String password) {
		this.id = id;
		this.iconId = iconId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	
	

}
