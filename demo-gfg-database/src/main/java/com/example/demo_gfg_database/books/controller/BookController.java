package com.example.demo_gfg_database.books.controller;

import com.example.demo_gfg_database.books.dtos.BookCreateRequest;
import com.example.demo_gfg_database.books.models.Book;
import com.example.demo_gfg_database.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;



    @PostMapping("/book")
    public void addBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) throws SQLException {

        this.bookService.addBook(bookCreateRequest);

//        return "Hello World";
    }

    @GetMapping("/book/all")
    public List<Book> getAllBooks() throws SQLException {

        return this.bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id")int bookId) throws SQLException {
        return this.bookService.getBookById(bookId);
    }
}
