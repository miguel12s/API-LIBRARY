package com.miguel.apibiblioteca.services;

import com.miguel.apibiblioteca.models.Author;
import com.miguel.apibiblioteca.models.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    void deleteById(Long id);
    List<Book> findAll();
    Book findById(Long id);
}
