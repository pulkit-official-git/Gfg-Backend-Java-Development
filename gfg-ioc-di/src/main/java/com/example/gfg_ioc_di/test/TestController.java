package com.example.gfg_ioc_di.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestConfiguration testConfiguration;

    @Autowired
    private TestService testService;
    private TestRepository testRepository;


    @Value("${test_int_val}")
    int TestInt;

//    @Bean
//    public int getIntbean(){
//        return TestInt;
//    }

    @Value("${test_string_val}")
    String TestString;

    @Value("${test_float_val}")
    Float TestFloat;

//    public TestController(){
//
//    }

//    @Autowired
//    public TestController(TestService testService,TestRepository testRepository,
//                          @Value("${test_int_val}") int TestInt,
//                          @Value("${test_string_val}")String TestString,
//                          @Value("${test_float_val}") Float TestFloat) {
//        this.testService = testService;
//        this.testRepository = testRepository;
//        this.testService.doSomething();
//        this.TestInt = TestInt;
//        this.TestString = TestString;
//        this.TestFloat = TestFloat;
//        this.testService = testService;
//    }
//    @Autowired
//    public TestController(TestRepository testRepository) {
//        this.testRepository = testRepository;
////        this.testService.doSomething();
////        this.testService = testService;
//    }

    @GetMapping("/test")
    public HashMap<String,Object> test() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("Int",TestInt);
        map.put("String",TestString);
        map.put("Float",TestFloat);
        return map;
    }

    @GetMapping("/test2")
    public void testMapper() {
        ObjectMapper o1 = this.testConfiguration.getMapper();
        ObjectMapper o2 = this.testConfiguration.getMapper();
        ObjectMapper o3 = this.testConfiguration.getMapper();
        ObjectMapper o4 = this.testConfiguration.getMapper();
        logger.info("inside testcontroller2: mapper-{}", o4);
    }
}
//private TestConfiguration testConfiguration;
