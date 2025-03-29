package com.example.gfg_rest_api.services;

import com.example.gfg_rest_api.dtos.UserPatchRequest;
import com.example.gfg_rest_api.dtos.UserRequest;
import com.example.gfg_rest_api.dtos.UserResponse;
import com.example.gfg_rest_api.dtos.UserUpdateRequest;
import com.example.gfg_rest_api.models.User;
import com.example.gfg_rest_api.repositories.UserRepository;

public class UserService {

    private UserRepository userRepository;
    public UserService() {
        this.userRepository = new UserRepository();
    }
    public User add(UserRequest userRequest) {
        User user = userRequest.to();
//        UserRepository userRepository = new UserRepository();
        return userRepository.createUser(user);
    }
    public UserResponse get(Integer id) {
//        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUser(id);
        return UserResponse.fromUser(user);

    }

    public User update(Integer id, UserUpdateRequest userUpdateRequest) {
        User user = userUpdateRequest.to();
        return userRepository.update(id,user);
    }

    public User updatePatch(Integer id, UserPatchRequest userPatchRequest) {
        User updatedUser = userPatchRequest.to();
        User existingUser = userRepository.getUser(id);

        User mergerData = merge(updatedUser, existingUser);
        return userRepository.update(id, mergerData);


//        merge

    }

    private User merge(User updatedUser, User existingUser) {
        if(existingUser == null) {
            return null;
        }
        if (updatedUser.getName()!=null){
            existingUser.setName(updatedUser.getName());
        }
        if(updatedUser.getPassword()!=null){
            existingUser.setPassword(updatedUser.getPassword());
        }
        if(updatedUser.getEmail()!=null){
            existingUser.setEmail(updatedUser.getEmail());
        }
        existingUser.setUpdatedAt(updatedUser.getUpdatedAt());
        return existingUser;
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }
}
