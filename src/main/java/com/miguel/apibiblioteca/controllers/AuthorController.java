package com.miguel.apibiblioteca.controllers;

import com.miguel.apibiblioteca.models.Author;
import com.miguel.apibiblioteca.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")

    public List<Author> author() {
        List<Author> autores = authorService.findAll();
        return autores;
    }


    @PostMapping(value = "/author")

    public ResponseEntity<Object> saveAuthor(@RequestBody Author author) {
        Map<String, Author> map = new HashMap<>();
        map.put("author", authorService.saveAuthor(author));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(map.get("author"));
    }

    @GetMapping(value = "author/{id}")

    public ResponseEntity<Object> getAuthorById(@PathVariable Long id) {
        Map<String, Author> map = new HashMap<>();
        try {
            Author author = authorService.findById(id);
            if (author != null) {
                map.put("author",author);
                return ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(map.get("author"));
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

    @DeleteMapping(value = "/author/{id}")
    public ResponseEntity<Object> deleteAuthorById(@PathVariable Long id){
        Map<String, String> map = new HashMap<>();
        try {
            Boolean author = authorService.existById(id);
            if (author) {
                authorService.deleteById(id);
                map.put("success","autor eliminado con exito");
                return ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body(map);
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se pudo encontrar el author");


        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en el servidor"+e.getMessage());
        }


    }

    @PutMapping(value="/author/{id}")

    public ResponseEntity<Object> updateAuthorById(@PathVariable Long id, @RequestBody Author author){
        Map<String, String> map = new HashMap<>();
        try {
            Author authorUpdate = authorService.findById(id);
            if (authorUpdate!=null) {
                authorUpdate.setName(author.getName());
                authorService.saveAuthor(author);
                map.put("success","autor actualizado con exito");
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(map);
            }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No se pudo actualizar el author");


        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en el servidor"+e.getMessage());
        }

    }



}
