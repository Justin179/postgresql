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