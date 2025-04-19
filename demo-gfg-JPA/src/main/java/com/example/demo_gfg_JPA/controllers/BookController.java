package com.example.demo_gfg_JPA.controllers;

import com.example.demo_gfg_JPA.dtos.BookCreateRequest;
import com.example.demo_gfg_JPA.models.Book;
import com.example.demo_gfg_JPA.models.Genre;
import com.example.demo_gfg_JPA.services.BookService;
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

    @GetMapping("/book/{book_id}")
    public Book getBookById(@PathVariable("book_id")Long book_id) throws SQLException {

        return this.bookService.getBookById(book_id);
    }

    @GetMapping("/book/genre/{genre}/native")
    public List<Book> getBookByGenreNative(@PathVariable("genre") Genre genre) throws SQLException {

        return this.bookService.getByGenreNative(genre);
    }

//    @GetMapping("/book/genre/{genre}/jpql")
//    public List<Book> getBookByGenreJPQL(@PathVariable("genre") Genre genre) throws SQLException {
//
//        return this.bookService.getBookByGenreJPQL(genre);
//    }
    @GetMapping("/book/genre/{genre}/author/{email}")
    public List<Book> getByGenreOrEmail(@PathVariable("genre") Genre genre,
                                            @PathVariable("email") String email) throws SQLException {

    return this.bookService.getBooksByGenreOrEmail(genre,email);
    }

    @PatchMapping("/book/genre/{genre}/id/{id}")
    public void updateGenreById(@PathVariable("genre") Genre genre, @PathVariable("id") Long id) throws SQLException {
        this.bookService.updateGenreById(genre,id);
    }



}