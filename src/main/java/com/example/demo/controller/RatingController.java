

package com.example.demo.controller;

import com.example.demo.entity.RatingResult;
import com.example.demo.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    /**
     * Triggers the rating engine to calculate and save a rating for a property.
     * Maps to POST /ratings/generate/{propertyId}
     */
    @PostMapping("/generate/{propertyId}")
    public ResponseEntity<RatingResult> generateRating(@PathVariable Long propertyId) {
        RatingResult result = ratingService.generateRating(propertyId);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Retrieves an existing rating result for a property.
     * Maps to GET /ratings/property/{propertyId}
     */
    @GetMapping("/property/{propertyId}")
    public ResponseEntity<RatingResult> getRating(@PathVariable Long propertyId) {
        RatingResult result = ratingService.getRating(propertyId);
        return ResponseEntity.ok(result);
    }
}



