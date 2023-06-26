package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
	@Query(
			value = "SELECT * FROM chats WHERE user_id = ?1 AND address_id = ?2", 
			nativeQuery = true
			)
	List<Chat> findEachChat(Integer id, Integer addressId);

}
