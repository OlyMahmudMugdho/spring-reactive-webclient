package com.mahmud.spring_reactive_webclient.service;

import com.mahmud.spring_reactive_webclient.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService {
    private final WebClient webClient;

    public TodoService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Todo> findAllTasks(){
        return webClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);
    }

    public Mono<Todo> findTaskById(int id){
        return webClient.get()
                .uri("/todos/{id}", id)
                .retrieve()
                .bodyToMono(Todo.class);
    }

    public Mono<Todo> addTask(Todo todo) {
        return webClient.post()
                .uri("/todos")
                .bodyValue(todo)
                .retrieve()
                .bodyToMono(Todo.class);
    }

    public Mono<Todo> updateTask(int id, Todo todo) {
        return webClient.put()
                .uri("/todos/{id}",id)
                .bodyValue(todo)
                .retrieve()
                .bodyToMono(Todo.class);
    }
}
