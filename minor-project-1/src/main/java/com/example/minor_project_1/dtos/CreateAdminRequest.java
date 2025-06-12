package com.example.minor_project_1.dtos;

import com.example.minor_project_1.models.Admin;
import com.example.minor_project_1.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String name;

    public Admin toAdmin(){
        Admin admin = Admin.builder()
                .name(this.name)
                .user(User.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
        return admin;
    }
}
