package com.example.gfg_rest_api.repositories;



import com.example.gfg_rest_api.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserRepository {

    Map<Integer,User> users = new HashMap<>();

    public User createUser(User user) {
        Integer userId = new Random().nextInt(100);
        user.setId(userId);
        users.put(user.getId(),user);
        return user;
//        users.put()
    }

    public User getUser(Integer id) {
        return users.get(id);
    }
}
