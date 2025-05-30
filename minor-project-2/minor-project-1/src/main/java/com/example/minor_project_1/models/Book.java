package com.example.minor_project_1.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {

//    JPA Joins
//    1:m
//    Book - Author  M:1

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("bookList")
    private Author author;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("bookList")
    private Student student;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    List<Transaction> transactionList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


}
