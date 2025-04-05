package com.example.gfg_ioc_di.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    Logger logger = LoggerFactory.getLogger(TestService.class);

     void doSomething() {
        logger.info("doSomething");
    }
}
