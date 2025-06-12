package com.example.minor_project_1.repositories;

import com.example.minor_project_1.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class StudentCacheRepository {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    private String STUDENT_KEY_PREFIX = "student::";

    private Long STUDENT_KEY_EXPIRY = 3600l;

    private String getKey(Integer id) {
        return STUDENT_KEY_PREFIX + id;
    }

    public void add(Student student) {
        String key = this.getKey(student.getId());
        redisTemplate.opsForValue().set(key,student,STUDENT_KEY_EXPIRY, TimeUnit.SECONDS);
    }

    public Student get(Integer id) {
        String key = this.getKey(id);
        Student student = (Student) redisTemplate.opsForValue().get(key);
        return student;
    }
}
