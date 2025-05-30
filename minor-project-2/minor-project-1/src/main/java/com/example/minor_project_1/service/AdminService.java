package com.example.minor_project_1.service;

import com.example.minor_project_1.dtos.CreateAdminRequest;
import com.example.minor_project_1.dtos.StudentCreateRequest;
import com.example.minor_project_1.models.Admin;
import com.example.minor_project_1.models.Authority;
import com.example.minor_project_1.models.Student;
import com.example.minor_project_1.models.User;
import com.example.minor_project_1.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    AdminRepository adminRepository;

    public Integer add(CreateAdminRequest createAdminRequest) {
//        Student student = studentCreateRequest.toStudent();
////        return this.studentRepository.save(student).getId(); // way 1 spring3
//        student = this.studentRepository.save(student);  // way 2  spring 3  spring 2
//        return student.getId();
        Admin admin = createAdminRequest.toAdmin();
        User uer = this.userService.createUser(admin.getUser(), Authority.ADMIN);
        admin.setUser(uer);
        this.adminRepository.save(admin);
        return admin.getId();
    }
}
