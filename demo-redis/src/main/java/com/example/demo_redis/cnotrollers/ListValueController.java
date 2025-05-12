package com.example.demo_redis.cnotrollers;

import com.example.demo_redis.dtos.CreatePersonRequest;
import com.example.demo_redis.model.Person;
import com.example.demo_redis.services.ListValueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class ListValueController {

    @Autowired
    ListValueService listValueService;

    @PostMapping("/lpush")
    public Long lpush(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        return this.listValueService.lpush(createPersonRequest.to());
    }

    @PostMapping("/rpush")
    public Long rpush(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        return this.listValueService.rpush(createPersonRequest.to());
    }

    @PostMapping("/lpop")
    public List<Person> lpop(@RequestParam(value = "count",required = false,defaultValue = "1")Integer count){
        return this.listValueService.lpop(count);
    }

    @PostMapping("/rpop")
    public List<Person> rpop(@RequestParam(value = "count",required = false,defaultValue = "1")Integer count){
        return this.listValueService.rpop(count);
    }

    @GetMapping("/lrange")
    public List<Person> lrange(@RequestParam(value = "start",required = false,defaultValue = "0")Integer start,
                               @RequestParam(value = "end",required = false,defaultValue = "-1")Integer end){
        return this.listValueService.lrange(start, end);
    }

}
