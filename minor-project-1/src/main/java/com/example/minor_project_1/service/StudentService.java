package com.example.minor_project_1.service;

import com.example.minor_project_1.dtos.StudentCreateResponse;
import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.models.Student;
import com.example.minor_project_1.repositories.BookRepository;
import com.example.minor_project_1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;


    public StudentCreateResponse getStudent(Integer id) {

        Student student = this.studentRepository.findById(id).orElse(null);
        List<Book> bookList = this.bookService.findByStudentId(id);

        StudentCreateResponse studentCreateResponse = StudentCreateResponse.builder()
                .student(student)
                .bookList(bookList)
                .build();

        return studentCreateResponse;
    }

//    public StudentCreateResponse getStudent(Integer id) {
//
//        Student student = this.studentRepository.findById(id).orElse(null);
//        List<Book> bookList = this.bookRepository.findByStudentId(id);
//
//        StudentCreateResponse studentCreateResponse = StudentCreateResponse.builder()
//                .student(student)
//                .bookList(bookList)
//                .build();
//
//        return studentCreateResponse;
//    }
}
