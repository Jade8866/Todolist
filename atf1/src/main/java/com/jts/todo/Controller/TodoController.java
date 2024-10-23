package com.jts.todo.Controller;

import com.jts.todo.dto.TodoDTO;

import com.jts.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Create a new Todo
    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO createdTodo = todoService.createTodo(todoDTO);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    // Retrieve all Todos
    @GetMapping(value = "")
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<TodoDTO> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // Retrieve a Todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.getTodoById(id);
        if (todoDTO != null) {
            return new ResponseEntity<>(todoDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update an existing Todo
    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {
        TodoDTO updatedTodo = todoService.updateTodo(id, todoDTO);
        if (updatedTodo != null) {
            return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a Todo by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
