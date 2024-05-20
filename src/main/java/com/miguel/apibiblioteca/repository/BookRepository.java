package com.miguel.apibiblioteca.repository;

import com.miguel.apibiblioteca.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
