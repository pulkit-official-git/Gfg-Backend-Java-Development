package com.example.demo_redis.services;

import com.example.demo_redis.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HashValueService {
// HK - hash key in terms of spring data redis  / Field in terms of redis
// HV - hash value in terms of spring data redis/ value in terms of redis
    /**
     * A Key K stores pairs of HK and HV
     *
     * K - String
     * HK - String
     * HV - Object
     * */

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static String REDIS_KEY_PREFIX = "person_hash::";
    private static final Long REDIS_KEY_EXPIRY = 10L;

    private String getKey(String id) {
        return REDIS_KEY_PREFIX + id;
    }
    public Person set(Person person) {
        // convert a person to map of field value
        Map<String,Object>fieldValue = this.objectMapper.convertValue(person,Map.class);
        this.redisTemplate.opsForHash().putAll(getKey(person.getId()), fieldValue);
        return person;
    }

    public Person get(String personId) {
        Map map = this.redisTemplate.opsForHash().entries(getKey(personId));
        return this.objectMapper.convertValue(map,Person.class);
    }

    public Object getValueForField(String personId, String fieldName) {
        return this.redisTemplate.opsForHash().get(getKey(personId), fieldName);
    }

    public void deleteField(String personId, String fieldName) {
        this.redisTemplate.opsForHash().delete(getKey(personId), fieldName);
    }
}
