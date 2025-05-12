package com.example.demo_redis.cnotrollers;

import com.example.demo_redis.dtos.CreatePersonRequest;
import com.example.demo_redis.model.Person;
import com.example.demo_redis.services.HashValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class HashValueController {

    @Autowired
    private HashValueService hashValueService;

    @PostMapping("/hash")
    public Person createPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        return this.hashValueService.set(createPersonRequest.to());
    }

    @DeleteMapping("/hash")
    public void deleteField(@RequestParam("id") String id,
                              @RequestParam("field") String field){
        this.hashValueService.deleteField(id, field);
    }

    @GetMapping("/hash/all")
    public Person getAll(@RequestParam("id") String id){
        return this.hashValueService.get(id);
    }

    @GetMapping("/hash/field")
    public Object createPerson(@RequestParam("id") String id,
                               @RequestParam("field") String field){
        return this.hashValueService.getValueForField(id,field);
    }



}
