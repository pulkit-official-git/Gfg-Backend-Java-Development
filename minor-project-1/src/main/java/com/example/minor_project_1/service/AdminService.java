package com.example.minor_project_1.service;

import com.example.minor_project_1.dtos.CreateAdminRequest;
import com.example.minor_project_1.models.Admin;
import com.example.minor_project_1.models.Authority;
import com.example.minor_project_1.models.User;
import com.example.minor_project_1.repositories.AdminRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    AdminRepository adminRepository;


    public Integer add(CreateAdminRequest createAdminRequest){

        Admin admin = createAdminRequest.toAdmin();
        User user = this.userService.createUser(admin.getUser(), Authority.ADMIN);
        admin.setUser(user);
        this.adminRepository.save(admin);
        return admin.getId();

    }


}
