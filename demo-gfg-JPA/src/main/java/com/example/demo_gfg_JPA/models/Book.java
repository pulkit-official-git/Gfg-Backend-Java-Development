package com.example.demo_gfg_JPA.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="my_book")
public class Book {
    //    private String externalId;
//
//    public void setExternalId(int externalId) {
//        this.externalId = "gfg "+externalId;
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="book_title", nullable=false, length=100)
    private String title;
    private String author;
    @Column(unique=true)
    private String authorEmail;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @CreationTimestamp
    private Date createdON;
    @UpdateTimestamp
    private Date updatedON;
}
