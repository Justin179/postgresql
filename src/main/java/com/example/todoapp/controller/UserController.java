package com.example.todoapp.controller;

import com.example.todoapp.model.User_;
import com.example.todoapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    List<User_> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    User_ createUser(@RequestBody User_ user) {
        return userRepository.save(user);
    }
}




//    @PutMapping("/{userId}/lists/{listId}")
//    User_ addListToUser(
//            @PathVariable Long listId,
//            @PathVariable Long userId
//    ) {
//        List_ list = listRepository.findById(listId).get();
//        User_ user = userRepository.findById(userId).get();
//        user.getLists().add(list);
//        return userRepository.save(user);
//    }