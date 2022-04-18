package com.example.todoapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item_ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    // 一個項目，會對到一個清單
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id", referencedColumnName = "id")
    private List_ list;

    public List_ getList() {
        return list;
    }
//    public void setList(List list) {
//        this.list = list;
//    }



    private String name;
    private String description;
    private Date deadline;

    public Long getId() {
        return id;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


}
