package com.miguel.apibiblioteca.services.impl;

import com.miguel.apibiblioteca.repository.AuthorRepository;
import com.miguel.apibiblioteca.models.Author;
import com.miguel.apibiblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public Author saveAuthor(Author author) {
       return  authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
         authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existById(Long id) {
        return authorRepository.existsById(id);
    }
}
