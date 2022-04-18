package com.example.todoapp.repo;

import com.example.todoapp.model.User_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User_, Long> {}
