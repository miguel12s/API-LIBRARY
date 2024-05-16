package com.miguel.apibiblioteca.dao;

import com.miguel.apibiblioteca.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends CrudRepository<Author,Long> {
}
