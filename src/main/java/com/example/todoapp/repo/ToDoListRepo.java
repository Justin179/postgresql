package com.example.todoapp.repo;

import com.example.postgresql.Student;
import com.example.todoapp.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
            "join todolist l on l.id = ulm.list_id where u.id=?1", nativeQuery = true)
    List<ToDoList> findListByUserIdNative(long userId);
}
