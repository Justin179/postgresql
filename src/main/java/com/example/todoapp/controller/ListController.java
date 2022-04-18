package com.example.todoapp.controller;

import com.example.todoapp.model.User_;
import com.example.todoapp.model.List_;
import com.example.todoapp.model.Item_;
import com.example.todoapp.repo.UserRepository;
import com.example.todoapp.repo.ListRepository;
import com.example.todoapp.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {

    @Autowired
    ListRepository listRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    List<List_> getLists() {
        return listRepository.findAll();
    }

    @PostMapping
    List_ createSubject(@RequestBody List_ list) {
        return listRepository.save(list);
    }



    // many to many : students to subjects
    // 學生加進科目
    @PutMapping("/{listId}/students/{userId}")
    List_ addUserToList(
            @PathVariable Long listId,
            @PathVariable Long userId
    ) {
        List_ list = listRepository.findById(listId).get();
        User_ user = userRepository.findById(userId).get();
        list.users.add(user);
        return listRepository.save(list);
    }

    // one to many : one teacher to many subjects
    // 每個科目，都會指定一個老師 (每個項目，都會指定一個清單)
    @PutMapping("/{listId}/item/{itemId}")
    List_ assignItemToList(
            @PathVariable Long listId,
            @PathVariable Long itemId
    ) {
        List_ list = listRepository.findById(listId).get();
        Item_ item = itemRepository.findById(itemId).get();
        list.setItem(item); // 每個科目，都會指定一個老師
        return listRepository.save(list);
    }
}
