package com.example.gfg_rest_api.dtos;

//import org.apache.catalina.User;

import com.example.gfg_rest_api.models.User;

public class UserCreateResponse {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
     public static UserCreateResponse fromUser(User user) {
        UserCreateResponse response = new UserCreateResponse();
        response.setId(user.getId());
        return response;
     }
}
