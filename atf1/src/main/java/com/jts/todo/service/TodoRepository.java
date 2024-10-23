package com.jts.todo.service;

import com.jts.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Custom query methods can be added here if needed
}
