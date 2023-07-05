package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Icon;

public interface IconRepository extends JpaRepository<Icon, Integer> {
	
}
