package com.miguel.apibiblioteca.services.impl;

import com.miguel.apibiblioteca.repository.BookRepository;
import com.miguel.apibiblioteca.models.Book;
import com.miguel.apibiblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book saveBook(Book book) {
     return   bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
         bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
