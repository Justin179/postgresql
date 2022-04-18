package com.example.todoapp.repo;

import com.example.todoapp.model.Item_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item_, Long> {}
