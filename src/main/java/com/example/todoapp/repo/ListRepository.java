package com.example.todoapp.repo;

import com.example.todoapp.model.List_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List_, Long> {}
