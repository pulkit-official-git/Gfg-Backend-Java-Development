package com.example.gfg_rest_api.dtos;

//import org.apache.catalina.User;

import com.example.gfg_rest_api.models.User;

import java.util.Date;

public class UserCreateResponse {

    private Integer id;
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public static UserCreateResponse fromUser(User user) {
        UserCreateResponse response = new UserCreateResponse();
        response.setId(user.getId());
        response.setCreatedAt(new Date());
        return response;
     }
}
