package com.example.todoapp.controller;

import com.example.todoapp.model.Item_;
import com.example.todoapp.model.List_;
import com.example.todoapp.repo.ItemRepository;
import com.example.todoapp.repo.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ListRepository listRepository;

    @PutMapping("/{itemId}/list/{listId}")
    Item_ assignItemToList(
            @PathVariable Long listId,
            @PathVariable Long itemId
    ) {
        List_ list = listRepository.findById(listId).get();
        Item_ item = itemRepository.findById(itemId).get();
        item.setList(list);
        return itemRepository.save(item);
    }


    @GetMapping
    List<Item_> getItems() {
        Sort sort = Sort.by("priority").ascending().and(Sort.by("deadline").ascending());
        return itemRepository.findAll(sort);
    }

    @PostMapping
    Item_ createItem(@RequestBody Item_ item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{itemId}")
    Item_ updateItem(@PathVariable Long itemId, @RequestBody Item_ item) {
        Item_ item_ = itemRepository.findById(itemId).get();
        item_.setName(item.getName());
        item_.setDescription(item.getDescription());
        item_.setDeadline(item.getDeadline());
        item_.setPriority(item.getPriority());

        return itemRepository.save(item_);
    }

}
