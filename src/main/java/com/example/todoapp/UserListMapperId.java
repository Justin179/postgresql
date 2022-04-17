package com.example.todoapp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserListMapperId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "list_id")
    private Long listId;

    public UserListMapperId() {
    }

    public UserListMapperId(Long userId, Long listId) {
        this.userId = userId;
        this.listId = listId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserListMapperId that = (UserListMapperId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(listId, that.listId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, listId);
    }
}
