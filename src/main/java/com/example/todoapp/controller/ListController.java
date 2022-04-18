package com.example.todoapp.controller;

import com.example.todoapp.model.ToDoList;
import com.example.todoapp.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @Autowired
    ListService listService;

    @GetMapping("/lists/{listId}")
    public ResponseEntity<ToDoList> getList(@PathVariable Long listId) throws Exception {

        ToDoList list = listService.getListById(listId); // 7L
        if (list!=null)
            return ResponseEntity.status(HttpStatus.OK).body(list);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
