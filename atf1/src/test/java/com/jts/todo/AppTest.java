package com.jts.todo;
import org.junit.jupiter.api.Test;




import com.jts.todo.dto.TodoDTO;
import com.jts.todo.entity.Todo;
import com.jts.todo.repository.TodoRepository;
import com.jts.todo.service.TodoService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
/**
 * Unit test for simple App.
 */

    public class AppTest {
        @Mock
        private TodoRepository todoRepository;

        @Mock
        private ModelMapper modelMapper;

        @InjectMocks
        private TodoService todoService;

        public AppTest() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testCreateTodo() {
            // Arrange
            TodoDTO todoDTO = new TodoDTO();
            todoDTO.setTitle("Test Todo");
            todoDTO.setDescription("Test Description");
            todoDTO.setCompleted(false);

            Todo todo = new Todo();
            when(modelMapper.map(todoDTO, Todo.class)).thenReturn(todo);
            when(todoRepository.save(todo)).thenReturn(todo);
            when(modelMapper.map(todo, TodoDTO.class)).thenReturn(todoDTO);

            // Act
            TodoDTO createdTodo = todoService.createTodo(todoDTO);

            // Assert
            assertNotNull(createdTodo);
            assertEquals("Test Todo", createdTodo.getTitle());
            verify(todoRepository, times(1)).save(todo);
        }
    }


