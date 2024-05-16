package com.miguel.apibiblioteca.services.impl;

import com.miguel.apibiblioteca.dao.BookDao;
import com.miguel.apibiblioteca.models.Book;
import com.miguel.apibiblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public void saveBook(Book book) {
        bookDao.save(book);
    }

    @Override
    public void deleteById(Long id) {
         bookDao.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id).orElse(null);
    }
}
