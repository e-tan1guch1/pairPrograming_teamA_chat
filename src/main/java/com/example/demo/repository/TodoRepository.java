package com.example.demo.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	Optional<Todo> findByreleaseDate(LocalDate releaseDate);
}
