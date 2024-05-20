package com.miguel.apibiblioteca.services.impl;

import com.miguel.apibiblioteca.models.Review;
import com.miguel.apibiblioteca.repository.ReviewRepository;
import com.miguel.apibiblioteca.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existById(Long id) {
        return reviewRepository.existsById(id);
    }
}
