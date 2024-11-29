package com.mahmud.spring_reactive_webclient.model;

public record Todo(int userId, int id, String title, boolean completed) {
}
