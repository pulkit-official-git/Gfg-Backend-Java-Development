package com.example.minor_project_1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @CreationTimestamp
    private Date createdAt;

    @JoinColumn
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("admin")
    private User user;
}


//user -> Admin  (1:1)

//user -> Student (1:1)

//sparse table i.e. for 200 entries if we have 100 students and 100 admins so in user table 100 admins will be null and 100 students will be null
