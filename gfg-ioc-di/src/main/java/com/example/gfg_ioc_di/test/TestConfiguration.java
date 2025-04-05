package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Configuration
public class TestConfiguration {

    Logger logger = LoggerFactory.getLogger(TestConfiguration.class);

    private ObjectMapper objectMapper;
    public TestConfiguration() {
        logger.info("TestConfiguration constructor: this-{},object-{}", this,this.objectMapper);
        this.objectMapper = new ObjectMapper();
    }

    @Scope("prototype")
    @Bean
    public ObjectMapper getMapper(){
        ObjectMapper om = new ObjectMapper();
        logger.info("Inside getMapper: mapper-{}",om);
        return om;
    }
}
