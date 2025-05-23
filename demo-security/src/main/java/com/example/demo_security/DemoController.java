package com.example.demo_security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoUserDetailsService demoUserDetailsService;

    @GetMapping("/user/hello")
    public String helloUser() {
        logger.info("inside DemoController");
        return "Hello User";
    }

    @GetMapping("/admin/hello")
    public String helloAdmin() {
        logger.info("inside DemoController");
        return "Hello Admin";
    }

    @GetMapping("/hello")
    public String hello() {
        logger.info("inside DemoController");
        return "Hello World";
    }

    @PostMapping("/admin/signup")
    public void signup(@RequestParam("pwd") String pwd,
                       @RequestParam("username") String username) {

        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(pwd)
                .authorities("ADMIN")
                .build();

        this.demoUserDetailsService.create(demoUser);
    }

    @PostMapping("/user/signup")
    public void signupUser(@RequestParam("pwd") String pwd,
                       @RequestParam("username") String username) {

        DemoUser demoUser = DemoUser.builder()
                .username(username)
                .password(pwd)
                .authorities("USER")
                .build();

        this.demoUserDetailsService.create(demoUser);
    }


}
