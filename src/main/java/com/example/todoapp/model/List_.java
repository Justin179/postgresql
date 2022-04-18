package com.example.todoapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class List_ {


    @ManyToMany
    @JoinTable( // will create a new table that joins
            name = "user_list",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public Set<User_> users = new HashSet<>();
    public Set<User_> getUsers() {
        return users;
    }


    // 一個清單下，會有多個項目
    @JsonIgnore
    @OneToMany(mappedBy = "list")
    private Set<Item_> items;

    public Set<Item_> getItems() {
        return this.items;
    }
    public void setItem(Item_ item) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
