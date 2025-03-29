package com.example.gfg_rest_api.dtos;

import com.example.gfg_rest_api.models.User;

import java.util.Date;

public class UserPatchRequest {
    private String name;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User to(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setUpdatedAt(new Date());
        user.setCreatedAt(user.getCreatedAt());
        return user;
    }
}
