package com.example.demo_gfg_database.books.dtos;

import com.example.demo_gfg_database.books.models.Genre;
import com.example.demo_gfg_database.books.models.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookCreateRequest {
    @NotBlank
    @Length(max = 50,min = 5)
    private String title;
    private String author;
    private String authorEmail;
    @NotNull
    private Genre genre;

    public Book to(){
        Book book = Book.builder()
                .title(this.title)
                .author(this.author)
                .authorEmail(this.authorEmail)
                .genre(this.genre)
                .createdON(new Date())
                .updatedON(new Date())
                .build();
        return book;
    }

}
