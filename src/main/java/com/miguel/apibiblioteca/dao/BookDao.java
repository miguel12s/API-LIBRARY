package com.miguel.apibiblioteca.dao;

import com.miguel.apibiblioteca.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book,Long> {
}
