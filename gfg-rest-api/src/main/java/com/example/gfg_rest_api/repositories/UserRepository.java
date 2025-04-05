package com.example.gfg_rest_api.repositories;



import com.example.gfg_rest_api.exceptions.UserNotFoundException;
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
        if(!users.containsKey(id)) {
            return null;
        }
        return users.get(id);
    }

    public User update(Integer id, User user) {
        if(!users.containsKey(id)) {
            return null;
        }
        user.setId(id);
        users.put(user.getId(),user);
        return user;

    }

    public void delete(Integer id){
            if(!users.containsKey(id)) {
                throw new UserNotFoundException("user not found");
            }
            users.remove(id);

    }
}
