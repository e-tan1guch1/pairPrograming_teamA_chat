package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {
	@Query(
			value = "SELECT * FROM requests WHERE user2_id = ?1", 
			nativeQuery = true
			)
	List<Request> findRequests(Integer user2Id);
	
	@Query(
			value = "SELECT * FROM requests WHERE user2_id = ?1 AND user_id = ?2", 
			nativeQuery = true
			)
	Optional<Request> findOnlyRequest(Integer user2Id, Integer userId);
	
	List<Request> findByUser2Id(Integer user2Id);
	
	List<Request> findByUserId(Integer userId);
}
