package com.mahmud.spring_reactive_webclient.controller;

import com.mahmud.spring_reactive_webclient.model.Todo;
import com.mahmud.spring_reactive_webclient.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
