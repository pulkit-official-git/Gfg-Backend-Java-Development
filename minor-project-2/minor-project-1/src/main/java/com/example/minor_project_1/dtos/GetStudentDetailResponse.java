package com.example.minor_project_1.dtos;

import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.models.Student;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetStudentDetailResponse {

    private Student student;

    private List<Book> bookList;
}
