package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
//	Optional<User> findByreleaseDateAndtext(String releaseDate, String text);
}
