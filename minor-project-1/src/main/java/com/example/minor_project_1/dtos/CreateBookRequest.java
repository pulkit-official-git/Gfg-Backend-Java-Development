package com.example.minor_project_1.dtos;

import com.example.minor_project_1.models.Author;
import com.example.minor_project_1.models.Book;
import com.example.minor_project_1.models.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {

    private String bookName;

    private Genre genre;

    private String authorName;

    private String authorEmail;

    public Book toBook(){
        Book book = Book.builder()
                .name(this.bookName)
                .genre(this.genre)
                .author(Author.builder()
                        .name(this.authorName)
                        .email(this.authorEmail)
                        .build())
                .build();
        return book;
    }

}
