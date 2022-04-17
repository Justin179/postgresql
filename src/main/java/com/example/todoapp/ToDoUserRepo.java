package com.example.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoUserRepo extends JpaRepository<ToDoUser, Long> {

}
