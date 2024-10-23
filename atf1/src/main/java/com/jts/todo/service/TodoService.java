package com.jts.todo.service;

import com.jts.todo.dto.TodoDTO;
import com.jts.todo.entity.Todo;
import com.jts.todo.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Convert Todo entity to DTO
    private TodoDTO convertToDto(Todo todo) {
        return modelMapper.map(todo, TodoDTO.class);
    }

    // Convert DTO to Todo entity
    private Todo convertToEntity(TodoDTO todoDTO) {
        return modelMapper.map(todoDTO, Todo.class);
    }

    // Create a new Todo
    public TodoDTO createTodo(TodoDTO todoDTO) {
        Todo todo = convertToEntity(todoDTO);
        Todo savedTodo = todoRepository.save(todo);
        return convertToDto(savedTodo);
    }

    // Retrieve all Todos
    public List<TodoDTO> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    // Retrieve a Todo by ID
    public TodoDTO getTodoById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        return todo.map(this::convertToDto).orElse(null);
    }

    // Update an existing Todo
    public TodoDTO updateTodo(Long id, TodoDTO todoDTO) {
        Optional<Todo> existingTodoOpt = todoRepository.findById(id);
        if (existingTodoOpt.isPresent()) {
            Todo existingTodo = existingTodoOpt.get();
            existingTodo.setTitle(todoDTO.getTitle());
            existingTodo.setDescription(todoDTO.getDescription());
            existingTodo.setCompleted(todoDTO.isCompleted());
            Todo updatedTodo = todoRepository.save(existingTodo);
            return convertToDto(updatedTodo);
        }
        return null;
    }

    // Delete a Todo by ID
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
