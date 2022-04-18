package com.example.todoapp.repo;

import com.example.todoapp.model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {
    // https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation
    /* 採用這個吧 (jpa的join 實在太難用)
        select l.* from todouser u
        join user_list_mapper ulm on u.id = ulm.user_id
        join todolist l on l.id = ulm.list_id
        where u.id=6;
     */
    @Query(value = "select l.* from todouser u " +
            "join user_list_mapper ulm on u.id = ulm.user_id " +
            "join todolist l on l.id = ulm.list_id where u.id=:userId", nativeQuery = true)
    List<ToDoList> findListByUserIdNative(@Param("userId") long userId);
}
