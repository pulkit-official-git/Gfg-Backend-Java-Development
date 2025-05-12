package com.example.demo_redis.services;

import com.example.demo_redis.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StringValueService {

    private static final String REDIS_KEY_PREFIX = "person::";
    private static final Long REDIS_KEY_EXPIRY = 10L;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    private String getKey(String id) {
        return REDIS_KEY_PREFIX + id;
    }

    public Person create(Person person) {
        redisTemplate.opsForValue().set(getKey(person.getId()),person,REDIS_KEY_EXPIRY, TimeUnit.MINUTES);
        return person;
    }

    public Person getPerson(String personId) {
        return (Person) redisTemplate.opsForValue().get(getKey(personId));
    }
}
