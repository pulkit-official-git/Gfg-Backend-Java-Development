package com.example.minor_project_1.dtos;

import com.example.minor_project_1.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudentRequest {

    private String name;

    private String email;

    private String mobile;

    public Student toStudent(){
        Student student = Student.builder()
                .name(this.name)
                .email(this.email)
                .mobile(this.mobile)
                .build();
        return student;
    }

}
