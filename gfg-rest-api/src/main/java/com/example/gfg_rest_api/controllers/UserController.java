package com.example.gfg_rest_api.controllers;

import com.example.gfg_rest_api.dtos.UserCreateResponse;
import com.example.gfg_rest_api.dtos.UserRequest;
import com.example.gfg_rest_api.dtos.UserResponse;
import com.example.gfg_rest_api.models.User;
import com.example.gfg_rest_api.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;
    public UserController() {
        this.userService = new UserService();
    }

    @PostMapping("user/post")
//    @ResponseBody
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UserCreateResponse createUser(@RequestBody UserRequest userRequest){

//        UserService userService = new UserService();
        User user = userService.add(userRequest);
        return UserCreateResponse.fromUser(user);
    }


    @GetMapping("user/fetch")
    public UserResponse getUser(@RequestParam("id") Integer id){
//        UserService userService = new UserService();
        return userService.get(id);
    }
}
