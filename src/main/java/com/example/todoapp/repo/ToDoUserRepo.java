package com.example.todoapp.repo;

import com.example.todoapp.model.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ToDoUserRepo extends JpaRepository<ToDoUser, Long> {
    /*
        select t.* from todouser u
        left join user_list_mapper ulm on u.id = ulm.user_id
        left join todolist t on t.id = ulm.list_id
        where u.id=6;
     */

    // SELECT e FROM Employee e LEFT JOIN e.address a ON a.city = :city




}
