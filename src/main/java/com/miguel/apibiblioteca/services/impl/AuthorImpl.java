package com.miguel.apibiblioteca.services.impl;

import com.miguel.apibiblioteca.dao.AuthorDao;
import com.miguel.apibiblioteca.models.Author;
import com.miguel.apibiblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorImpl implements AuthorService {
    @Autowired
    private AuthorDao authorDao;
    @Override
    public Author saveAuthor(Author author) {
       return  authorDao.save(author);
    }

    @Override
    public void deleteById(Long id) {
         authorDao.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorDao.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorDao.findById(id).orElse(null);
    }

    @Override
    public Boolean existById(Long id) {
        return authorDao.existsById(id);
    }
}
