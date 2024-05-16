package com.miguel.apibiblioteca.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int pages;
    private String genre;
    @ManyToMany
    private List<Author> autores;
}
