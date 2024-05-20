package com.miguel.apibiblioteca.controllers;

import com.miguel.apibiblioteca.models.Review;
import com.miguel.apibiblioteca.repository.ReviewRepository;
import com.miguel.apibiblioteca.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;


    @PostMapping(value = "")

    public ResponseEntity<Review> save(@RequestBody Review review) {

        return ResponseEntity.ok(reviewService.save(review));
    }

    @GetMapping("")

    public ResponseEntity<List<Review>> reviewAll() {
        return ResponseEntity.ok((List<Review>) reviewService.findAll());
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Object> deleteReviewByid(@PathVariable Long id) {
        Map<String, String> message = new HashMap<>();

        try {
            if(reviewService.existById(id)) {

            reviewService.deleteById(id);
            message.put("success", "Review eliminated");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
            }
                message.put("error", "Review not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);




        } catch (Exception e) {
            message.put("error", "the review is not eliminated");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }


}
