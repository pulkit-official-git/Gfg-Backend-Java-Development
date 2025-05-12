package com.example.demo_redis.cnotrollers;

import com.example.demo_redis.dtos.CreatePersonRequest;
import com.example.demo_redis.model.Person;
import com.example.demo_redis.services.StringValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class StringValueController {

    @Autowired
    private StringValueService stringValueService;

    @PostMapping("/value")
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        return this.stringValueService.create(createPersonRequest.to());
    }

    @GetMapping("/value/{id}")
    public Person getPerson(@PathVariable("id") String id) {
        return this.stringValueService.getPerson(id);
    }
}
