package com.example.todoapp;

import com.example.postgresql.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

}
