package com.example.minor_project_1.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String externalId;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactionList")
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("transactionList")
    private Student student;

    @Enumerated(EnumType.ORDINAL)
    private TransactionStatus status;

    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    private Integer fine;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


}
