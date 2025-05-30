package com.example.minor_project_1.controllers;

import com.example.minor_project_1.dtos.GetStudentDetailResponse;
import com.example.minor_project_1.dtos.StudentCreateRequest;
import com.example.minor_project_1.dtos.UpdateStudentRequest;
import com.example.minor_project_1.models.Student;
import com.example.minor_project_1.models.User;
import com.example.minor_project_1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Integer addStudent(@RequestBody StudentCreateRequest studentCreateRequest) {

        return this.studentService.add(studentCreateRequest);
    }

    @GetMapping("/admin/{studentId}")
    public GetStudentDetailResponse getStudentbyAdmin(@PathVariable("studentId") Integer id){
        return this.studentService.getStudent(id);
    }

    @GetMapping("")
    public GetStudentDetailResponse getStudent(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer id = user.getStudent().getId();
        return this.studentService.getStudent(id);
    }

    @PatchMapping("")
    public GetStudentDetailResponse updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer id = user.getStudent().getId();
        return this.studentService.updateStudent(id,updateStudentRequest);
    }

    @DeleteMapping("")
    public GetStudentDetailResponse deactivate(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Integer id = user.getStudent().getId();
        return this.studentService.deactivate(id);
    }
}
