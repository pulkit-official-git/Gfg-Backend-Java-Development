package com.example.gfg_rest_api.dtos;

import com.example.gfg_rest_api.models.User;

import java.util.Date;

public class UserUpdateResponse {
    private Integer id;

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Date updatedAt;
    public static UserUpdateResponse fromUser(User user) {
        UserUpdateResponse response = new UserUpdateResponse();
        if(user == null) {
            return null;
        }
        response.setId(user.getId());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }
}
