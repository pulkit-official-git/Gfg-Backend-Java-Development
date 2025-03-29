package com.example.gfg_rest_api.dtos;

import com.example.gfg_rest_api.Gender;
import com.example.gfg_rest_api.models.User;

import java.util.Date;

public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User to(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setAge(this.age);
        user.setGender(this.gender);
        user.setCreatedAt(new Date());
        return user;
    }
}
