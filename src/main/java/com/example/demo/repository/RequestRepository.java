package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {
	@Query(
			value = "SELECT * FROM requests WHERE reciever_id = ?1", 
			nativeQuery = true
			)
	List<Request> findRequests(Integer recieverId);
	
	@Query(
			value = "SELECT * FROM requests WHERE reciever_id = ?1 AND sender_id = ?2", 
			nativeQuery = true
			)
	Optional<Request> findOnlyRequest(Integer recieverId, Integer senderId);
	
	List<Request> findByRecieverId(Integer recieverId);
	
	List<Request> findBySenderId(Integer senderId);
}
