package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Friend;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
	@Query(
			value = "SELECT * FROM friends WHERE user_id = ?1", 
			nativeQuery = true
			)
	List<Friend> findFriend(Integer userId);
	
	@Query(
			value = "SELECT * FROM friends WHERE user_id = ?1 AND user2_id = ?2", 
			nativeQuery = true
			)
	Optional<Friend> findOnlyFriendId(Integer userId, Integer user2_id);
}
