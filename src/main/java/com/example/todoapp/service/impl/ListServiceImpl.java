package com.example.todoapp.service.impl;

import com.example.todoapp.model.ToDoItem;
import com.example.todoapp.model.ToDoList;
import com.example.todoapp.model.ToDoUser;
import com.example.todoapp.repo.ToDoItemRepo;
import com.example.todoapp.repo.ToDoListRepo;
import com.example.todoapp.service.ListService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ListServiceImpl implements ListService {

    @Autowired
    private ToDoListRepo listRepo;

    @Autowired
    private ToDoItemRepo itemRepo;

    @Override
    public ToDoList getListById(Long listId) throws Exception {
        Optional<ToDoList> list = listRepo.findById(listId);

        if (list.isPresent())
            return list.get();
        else
            throw new Exception("listId: "+listId+ " not found");
    }

    @Override
    public Integer createList(ToDoList toDoList) {

        ToDoList list = makeAToDoList();
        for (int i = 0; i<3; i++){
            list.addItem(makeAItem()); // 在一個清單中，加入三個項目
        }
        ToDoList save = listRepo.save(list);

        return 1;
    }

    @Override
    public void updateList(Long listId, ToDoList toDoList) {
//        listRepo.findById(2l).ifPresent(toDoList -> {
//            Faker faker = new Faker();
//            String name = faker.name().name();
//            toDoList.setName(name);
//            List<ToDoItem> items = toDoList.getItems();
//            items.forEach(toDoItem -> {
//                String item_name = faker.name().name();
//                toDoItem.setName(item_name);
//                itemRepo.save(toDoItem);
//            });
//            listRepo.save(toDoList); // save
//        });
    }

    @Override
    public void deleteListById(Long listId) {
        listRepo.findById(2l).ifPresent(listRepo::delete);
    }


    private ToDoList makeAToDoList() {
        Faker faker = new Faker();
        String name = faker.name().name();
        ToDoList list = new ToDoList(name, LocalDateTime.now());
        return list;
    }

    private ToDoUser makeAUser() {
        Faker faker = new Faker();
        String username = faker.name().username();
        ToDoUser user = new ToDoUser(username);
        return user;
    }

    private ToDoItem makeAItem() {
        Faker faker = new Faker();
        String name = faker.name().name();
        String description = faker.commerce().productName();
        ToDoItem item = new ToDoItem(name, description, LocalDateTime.now());
        return item;
    }

}
