package com.example.demo_gfg_database.books.service;

import com.example.demo_gfg_database.books.dtos.BookCreateRequest;
import com.example.demo_gfg_database.books.repository.BookRepository;
import com.example.demo_gfg_database.books.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(BookCreateRequest bookCreateRequest) throws SQLException {
            Book book = bookCreateRequest.to();
            this.bookRepository.addBook(book);
    }

    public List<Book> getAllBooks() throws SQLException {
        return this.bookRepository.getAllBooks();
    }
}
