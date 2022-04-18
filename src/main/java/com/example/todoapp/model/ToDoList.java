package com.example.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ToDoList")
@Table(name = "todolist")
public class ToDoList {

    @Id
    @SequenceGenerator(
            name = "todolist_sequence",
            sequenceName = "todolist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "todolist_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "due_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime dueDate;

    @OneToMany ( // one list to many items (前者One是主體)
            mappedBy = "toDoList",
            orphanRemoval = true, // when remove a list, also remove items associate with the list
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, // list add item 就會直接寫進book table
            // The cascade persist is used to specify that if an entity is persisted then all its associated child entities will also be persisted.
            // CascadeType. REMOVE : It means that the related entities are deleted when the owning entity is deleted.
            // CascadeType. DETACH. The detach operation removes the entity from the persistent context.
            // When we use CascadeType. DETACH, the child entity will also get removed from the persistent context.
            fetch = FetchType.LAZY // 要注意使用這個的效能，所以default 用lazy，真的需要才改為Eager
    )
    private List<ToDoItem> items = new ArrayList<>();

    public void addItem(ToDoItem item) {
        if (!this.items.contains(item)) {
            this.items.add(item);
            item.setToDoList(this); // bi-directional
        }
    }

    public void removeItem(ToDoItem item){
        if(this.items.contains(item)){
            this.items.remove(item);
            item.setToDoList(null);
        }
    }
    public List<ToDoItem> getItems(){
        return items;
    }



    @OneToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            mappedBy = "toDoList"
    )
    @JsonIgnore
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

    public ToDoList() {
    }

    public ToDoList(String name, LocalDateTime dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", items=" + items +
                '}';
    }
}
