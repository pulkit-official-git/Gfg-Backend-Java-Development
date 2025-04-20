package com.example.minor_project_1.service;

import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findByStudentId(Integer studentId) {
        return bookRepository.findByStudentId(studentId);
    }
}
