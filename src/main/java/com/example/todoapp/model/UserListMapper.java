package com.example.todoapp.model;

import javax.persistence.*;

@Entity(name = "UserListMapper")
@Table(name = "user_list_mapper")
public class UserListMapper {

    @EmbeddedId
    private UserListMapperId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(
                    name = "mapper_user_id_fk"
            )
    )
    private ToDoUser user;

    @ManyToOne
    @MapsId("listId")
    @JoinColumn(
            name = "list_id",
            foreignKey = @ForeignKey(
                    name = "mapper_list_id_fk"
            )
    )
    private ToDoList toDoList;

    public UserListMapper(UserListMapperId id, ToDoUser user, ToDoList toDoList) {
        this.id = id;
        this.user = user;
        this.toDoList = toDoList;
    }

    public UserListMapper(ToDoUser user, ToDoList toDoList) {
        this.user = user;
        this.toDoList = toDoList;
    }

    public UserListMapper() {
    }

    public UserListMapperId getId() {
        return id;
    }

    public void setId(UserListMapperId id) {
        this.id = id;
    }

    public ToDoUser getUser() {
        return user;
    }

    public void setUser(ToDoUser user) {
        this.user = user;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }
}
