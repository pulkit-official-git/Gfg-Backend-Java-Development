package com.example.gfg_rest_api.services;

import com.example.gfg_rest_api.dtos.UserRequest;
import com.example.gfg_rest_api.dtos.UserResponse;
import com.example.gfg_rest_api.models.User;
import com.example.gfg_rest_api.repositories.UserRepository;

public class UserService {

    private UserRepository userRepository;
    public UserService() {
        this.userRepository = new UserRepository();
    }
    public User add(UserRequest userRequest) {
        User user = UserRequest.to(userRequest);
//        UserRepository userRepository = new UserRepository();
        return userRepository.createUser(user);
    }
    public UserResponse get(Integer id) {
//        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUser(id);
        return UserResponse.fromUser(user);

    }
}
