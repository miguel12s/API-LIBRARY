package com.miguel.apibiblioteca.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name="author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToMany()
//    @JoinTable(name = "book_id")
//    private List<Review> reviews;

}
