package com.mahmud.spring_reactive_webclient.service;

import com.mahmud.spring_reactive_webclient.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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
}
