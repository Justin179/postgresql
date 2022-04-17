package com.example.todoapp.repo;

import com.example.todoapp.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoUserRepo extends JpaRepository<ToDoUser, Long> {

}
