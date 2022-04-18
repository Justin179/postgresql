package com.example.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "ToDoItem")
@Table(name = "todoitem")
public class ToDoItem {

    @Id
    @SequenceGenerator(
            name = "todoitem_sequence",
            sequenceName = "todoitem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "todoitem_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "description",
            nullable = false
    )
    private String description;

    @Column(
            name = "deadline",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime deadline;




    @ManyToOne // many items to one list (前者many是主體)
    @JoinColumn(
            name = "list_id", // item.student_id (FK)
            nullable = false,
            referencedColumnName = "id", // list.id (PK)
            foreignKey = @ForeignKey(
                    name = "list_item_fk"
            )
    )
    private ToDoList toDoList;

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }


    // ------------------------------- auto generated below

    public ToDoItem() {
    }

    public ToDoItem(String name, String description, LocalDateTime deadline) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}



















