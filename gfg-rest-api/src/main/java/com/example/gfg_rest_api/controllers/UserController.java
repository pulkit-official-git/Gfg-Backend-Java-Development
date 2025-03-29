package com.example.gfg_rest_api.controllers;

import com.example.gfg_rest_api.dtos.*;
import com.example.gfg_rest_api.models.User;
import com.example.gfg_rest_api.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    public Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    public UserController() {
        this.userService = new UserService();
    }

    @PostMapping("user")
//    @ResponseBody
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UserCreateResponse createUser(@RequestBody UserRequest userRequest){

//        UserService userService = new UserService();
        User user = userService.add(userRequest);
        return UserCreateResponse.fromUser(user);
    }


    @GetMapping("user")
    public UserResponse getUser(@RequestParam("id") Integer id){
//        UserService userService = new UserService();
        return userService.get(id);
    }

    @PutMapping("user/update/{userId}")
    public UserUpdateResponse updateUser(@PathVariable("userId") Integer id, @RequestBody UserUpdateRequest userUpdateRequest){
        User user = userService.update(id,userUpdateRequest);
        logger.info("updated user: {}"+user);
        return UserUpdateResponse.fromUser(user);
    }

    @PatchMapping("user/partial/update/{userId}")
    public UserUpdateResponse updateUser(@PathVariable("userId") Integer id, @RequestBody UserPatchRequest userPatchRequest){
        User user = userService.updatePatch(id,userPatchRequest);
        logger.info("updated patch user: {}"+user);
        return UserUpdateResponse.fromUser(user);
    }

    @DeleteMapping("user/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id){
        userService.delete(id);
    }
}
