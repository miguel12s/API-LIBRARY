package com.miguel.apibiblioteca.controllers;

import com.miguel.apibiblioteca.models.Book;
import com.miguel.apibiblioteca.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value="/book")
    public List<Book> book(){
        return bookService.findAll();
    }

    @PostMapping(value="/book")

    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }


}
