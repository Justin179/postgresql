package com.example.todoapp.controller;

import com.example.todoapp.model.Item_;
import com.example.todoapp.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    List<Item_> getItems() {
        return itemRepository.findAll();
    }

    @PostMapping
    Item_ createItem(@RequestBody Item_ item) {
        return itemRepository.save(item);
    }
}
