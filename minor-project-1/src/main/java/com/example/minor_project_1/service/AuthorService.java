package com.example.minor_project_1.service;

import com.example.minor_project_1.models.Author;
import com.example.minor_project_1.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author saveOrGet(Author author) {
        Author savedAuthor = this.authorRepository.findByEmail(author.getEmail());

        if (savedAuthor == null) {
            author = this.authorRepository.save(author);
            return author;
        }
        return savedAuthor;
    }
}
