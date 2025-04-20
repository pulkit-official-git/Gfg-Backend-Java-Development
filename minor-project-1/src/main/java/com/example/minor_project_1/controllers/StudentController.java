package com.example.minor_project_1.controllers;

import com.example.minor_project_1.dtos.StudentCreateResponse;
import com.example.minor_project_1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public StudentCreateResponse getStudent(Integer id){

        return this.studentService.getStudent(id);
    }
}
