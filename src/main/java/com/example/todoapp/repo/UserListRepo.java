package com.example.todoapp.repo;

import com.example.todoapp.ToDoList;
import com.example.todoapp.ToDoUser;
import com.example.todoapp.UserListMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserListRepo extends JpaRepository<UserListMapper, Long> {

}
