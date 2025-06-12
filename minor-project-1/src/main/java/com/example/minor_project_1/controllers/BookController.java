package com.example.minor_project_1.controllers;

import com.example.minor_project_1.dtos.CreateBookRequest;
import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public Integer addBook(@RequestBody CreateBookRequest createBookRequest) {
        return this.bookService.addBook(createBookRequest);
    }

    @GetMapping("{bookId}")
    public Book getBook(@PathVariable("bookId") Integer bookId) {
        return this.bookService.getBooks(bookId);
    }

//    Task :-  create a get Api with some filters in single get api and also include pagination.


}
