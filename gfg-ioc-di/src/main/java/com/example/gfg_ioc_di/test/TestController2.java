package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    Logger logger = LoggerFactory.getLogger(TestController2.class);

    @Autowired
    private TestConfiguration testConfiguration;

    @GetMapping("/test3")
    public void test() {
        ObjectMapper objectMapper = testConfiguration.getMapper();
        logger.info("inside testcontroller2: mapper-{}",objectMapper);
    }
}
