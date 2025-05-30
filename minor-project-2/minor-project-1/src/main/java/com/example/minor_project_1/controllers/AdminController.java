package com.example.minor_project_1.controllers;

import com.example.minor_project_1.dtos.CreateAdminRequest;
import com.example.minor_project_1.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/add")
    public Integer addAdmin(@Valid @RequestBody CreateAdminRequest createAdminRequest) {
        return this.adminService.add(createAdminRequest);
    }
}
