package com.example.demo_gfg_JPA.services;

import com.example.demo_gfg_JPA.dtos.BookCreateRequest;
import com.example.demo_gfg_JPA.models.Book;
import com.example.demo_gfg_JPA.models.Genre;
import com.example.demo_gfg_JPA.repositories.BookRepository;
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
        bookRepository.save(book);
//        this.bookRepository.addBook(book);
    }

    public List<Book> getAllBooks() throws SQLException {
//        return this.bookRepository.getAllBooks();
        return bookRepository.findAll();
//        return null;
    }


    public Book getBookById(Long bookId) {
        return this.bookRepository.findById(bookId).orElse(null);
    }

//    public List<Book> getBookByGenreNative(Genre genre) {
////        return this.bookRepository.getBookByGenreNative(genre);
//        return this.bookRepository.findByGenre(genre);
//    }

    public List<Book> getBooksByGenreOrEmail(Genre genre, String email) {
        return this.bookRepository.findBooksByGenreOrAuthorEmail(genre,email);
    }

    public List<Book> getByGenreNative(Genre genre) {
        return this.bookRepository.getByGenreNative(genre);
    }

    public void updateGenreById(Genre genre, Long id) {
        Book book = this.bookRepository.findById(id).orElse(null);
        book.setGenre(genre);
        bookRepository.save(book);
//        this.bookRepository.updateGenreById(genre,id);
    }
}