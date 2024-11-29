package com.mahmud.spring_reactive_webclient.controller;

import com.mahmud.spring_reactive_webclient.model.Todo;
import com.mahmud.spring_reactive_webclient.service.TodoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    public TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Flux<Todo> getAllTasks() {
        return todoService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Mono<Todo> getTodoById(@PathVariable int id){
        return todoService.findTaskById(id);
    }

    @PostMapping
    public Mono<Todo> createTodo(@RequestBody Todo todo){
        return todoService.addTask(todo);
    }

    @PutMapping("/{id}")
    public Mono<Todo> updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        return todoService.updateTask(id, todo);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTodo(@PathVariable int id){
        return todoService.deleteTask(id);
    }
}
