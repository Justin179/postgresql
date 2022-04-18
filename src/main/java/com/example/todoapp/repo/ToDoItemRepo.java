package com.example.todoapp.repo;

import com.example.todoapp.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ToDoItemRepo extends JpaRepository<ToDoItem, Long> {

}
