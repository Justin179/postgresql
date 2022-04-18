package com.example.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User_ {


    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<List_> lists = new HashSet<>();
    public Set<List_> getLists() {
        return lists;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String username;


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
