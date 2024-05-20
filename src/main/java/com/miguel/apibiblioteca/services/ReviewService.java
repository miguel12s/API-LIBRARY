package com.miguel.apibiblioteca.services;

import com.miguel.apibiblioteca.models.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    Review save(Review review);
    void deleteById(Long id);
    Review findById(Long id);
    Boolean existById(Long id);

}
