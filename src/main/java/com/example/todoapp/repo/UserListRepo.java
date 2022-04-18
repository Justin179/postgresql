package com.example.todoapp.repo;

import com.example.todoapp.model.UserListMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserListRepo extends JpaRepository<UserListMapper, Long> {

}
