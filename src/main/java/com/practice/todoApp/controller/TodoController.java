package com.practice.todoApp.controller;

import com.practice.todoApp.model.Todo;
import com.practice.todoApp.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@CrossOrigin("*")  // Enable CORS for frontend access
public class TodoController {
    @Autowired
    private TodoService todoService;

    @Operation(summary = "Get all To-Dos")
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Operation(summary = "Get a single To-Do by ID")
    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);
    }

    @Operation(summary = "Create a new To-Do")
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @Operation(summary = "Update a To-Do by ID")
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        return todoService.updateTodo(id, updatedTodo);
    }

    @Operation(summary = "Delete a To-Do by ID")
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable String id) {
        todoService.deleteTodoById(id);
    }
}
