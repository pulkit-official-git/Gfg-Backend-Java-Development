package com.example.minor_project_1.dtos;

import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.models.Student;
import com.example.minor_project_1.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String name;

    private String email;

    @NotBlank
    private String mobile;

    public Student toStudent(){
        Student student = Student.builder()
                .name(this.name)
                .email(this.email)
                .mobile(this.mobile)
                .user(User.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
        return student;
    }

}
