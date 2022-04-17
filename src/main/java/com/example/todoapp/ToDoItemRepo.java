package com.example.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepo extends JpaRepository<ToDoItem, Long> {

}
