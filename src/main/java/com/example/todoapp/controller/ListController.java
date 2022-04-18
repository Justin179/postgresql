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
    @PutMapping("/{listId}/users/{userId}")
    List_ addUserToList(
            @PathVariable Long listId,
            @PathVariable Long userId
    ) {
        List_ list = listRepository.findById(listId).get();
        User_ user = userRepository.findById(userId).get();
        list.users.add(user);
        return listRepository.save(list);
    }

    @PutMapping("/{listId}")
    List_ updateList(@PathVariable Long listId, @RequestBody List_ list) {
        List_ list_ = listRepository.findById(listId).get();
        list_.setName(list.getName());
        list_.setDueDate(list.getDueDate());
        return listRepository.save(list_);
    }
}
