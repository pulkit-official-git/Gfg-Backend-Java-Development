package com.example.demo_gfg_database.books.models;

import lombok.*;

import java.util.Date;



@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
//    private String externalId;
//
//    public void setExternalId(int externalId) {
//        this.externalId = "gfg "+externalId;
//    }
    private int id;
    private String title;
    private String author;
    private String authorEmail;
    private Genre genre;
    private Date createdON;
    private Date updatedON;
}
