package com.miguel.apibiblioteca.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Author author;
//    @OneToMany(  cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
//
//    private List<Review> reviews;
}
