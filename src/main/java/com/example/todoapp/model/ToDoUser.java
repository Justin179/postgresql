package com.example.todoapp.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ToDoUser")
@Table(
        name = "todouser"
)
public class ToDoUser {

    @Id
    @SequenceGenerator(
            name = "todouser_sequence",
            sequenceName = "todouser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "todouser_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;


    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "user"
    )
    private List<UserListMapper> userListMappers = new ArrayList<>();


    public List<UserListMapper> getUserListMappers() {
        return userListMappers;
    }

    public void addUserListMapper(UserListMapper userListMapper) {
        if (!userListMappers.contains(userListMapper)) {
            userListMappers.add(userListMapper);
        }
    }

    public void removeUserListMapper(UserListMapper userListMapper) {
        userListMappers.remove(userListMapper);
    }

    // ------------------------------- auto generated below

    public ToDoUser(String username) {
        this.username = username;
    }

    public ToDoUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ToDoUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}