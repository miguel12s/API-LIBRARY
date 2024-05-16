package com.miguel.apibiblioteca.services;

import com.miguel.apibiblioteca.models.Author;

import java.util.List;

public interface AuthorService {
    Author saveAuthor(Author author);
    void deleteById(Long id);
    List<Author> findAll();
    Author findById(Long id);
    Boolean existById(Long id);
}
