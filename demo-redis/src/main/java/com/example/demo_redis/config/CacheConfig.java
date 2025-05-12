package com.example.demo_redis.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CacheConfig {

    @Bean
    ObjectMapper getMapper() {
        return new ObjectMapper();
    }

    @Bean
    RedisConnectionFactory getConnection(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(
                "redis-17600.c330.asia-south1-1.gce.redns.redis-cloud.com",17600

        );
        redisStandaloneConfiguration.setPassword("0EKft4KX2kiM6ZvPGLCKf8kL25Y5hTuA");
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> getTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getConnection());

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());

        return redisTemplate;
    }
}
