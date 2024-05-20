package com.miguel.apibiblioteca.controllers;

import com.miguel.apibiblioteca.models.Author;
import com.miguel.apibiblioteca.models.Book;
import com.miguel.apibiblioteca.services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1")
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping(value="/book")
    public List<Book> book(){
        return bookService.findAll();
    }

    @GetMapping(value="/book/{id}")

    public ResponseEntity<Object> getBook(@PathVariable Long id){
        Map<String, Book> map = new HashMap<>();
        try {
            Book book = bookService.findById(id);
            if (book != null) {
                map.put("book",book);
                return ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(map);
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se pudo encontrar el libro");


        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en el servidor"+e.getMessage());
        }
    }

    @PostMapping(value="/book")

    public ResponseEntity<Object> saveBook(@RequestBody Book book){
        Map<String, Book> map = new HashMap<>();
        map.put("book", bookService.saveBook(book));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(map.get("book"));
    }

    @PutMapping(value="/book/{id}")

    public ResponseEntity<Object> updateAuthorById(@PathVariable Long id, @RequestBody Book book){
        Map<String, String> map = new HashMap<>();
        try {
            Book bookUpdate = bookService.findById(id);
            if (bookUpdate!=null) {
                bookUpdate.setName(book.getName());
                bookService.saveBook(bookUpdate);
                map.put("success","libro actualizado con exito");
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(map);
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se pudo actualizar el libro");


        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en el servidor"+e.getMessage());
        }

    }


}
