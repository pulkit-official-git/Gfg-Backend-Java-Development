package com.example.minor_project_1.repositories;

import com.example.minor_project_1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    public Author findByEmail(String email);
}
