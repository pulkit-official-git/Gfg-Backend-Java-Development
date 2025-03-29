//package com.example.gfg_rest_api.controllers;
//
//import com.example.gfg_rest_api.dtos.UserCreateResponse;
//import com.example.gfg_rest_api.dtos.UserRequest;
//import com.example.gfg_rest_api.models.User;
//import com.example.gfg_rest_api.services.UserService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserController2 {
//
//    private UserService userService;
//
//    public UserController2() {
//        this.userService = new UserService();
//    }
//
//    @PostMapping("user")
////    @ResponseBody
////    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public UserCreateResponse createUser(@RequestBody UserRequest userRequest){
//
////        UserService userService = new UserService();
//        User user = userService.add(userRequest);
//        return UserCreateResponse.fromUser(user);
//    }
//}
