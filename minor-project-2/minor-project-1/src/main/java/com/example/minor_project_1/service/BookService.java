package com.example.minor_project_1.service;

import com.example.minor_project_1.dtos.CreateBookRequest;
import com.example.minor_project_1.models.Author;
import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public List<Book> findByStudentId(Integer studentId) {
        return bookRepository.findByStudentId(studentId);
    }

    public Integer addBook(CreateBookRequest createBookRequest) {
        Book book = createBookRequest.toBook();
        Author author = authorService.saveOrGet(book.getAuthor());
        book.setAuthor(author);
        book= bookRepository.save(book);
        return book.getId();
    }

    public Book getBooks(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        return book;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
