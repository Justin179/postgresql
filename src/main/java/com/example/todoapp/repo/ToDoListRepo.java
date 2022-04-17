package com.example.todoapp.repo;

import com.example.postgresql.Student;
import com.example.todoapp.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

}
