package com.example.todoapp.service;

import com.example.todoapp.model.ToDoList;

public interface ListService {
    ToDoList getListById(Long listId) throws Exception;

    Integer createList(ToDoList toDoList);

    void updateList(Long listId, ToDoList toDoList);

    void deleteListById(Long listId);
}
