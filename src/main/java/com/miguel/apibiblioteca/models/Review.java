package com.miguel.apibiblioteca.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //add more attributes for review model
    private String content;
    private int rating;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date_review;

    @ManyToOne
    @JoinColumn(name="book_id")

    private Book book;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
