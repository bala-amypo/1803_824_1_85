// package com.example.demo.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.demo.entity.RatingResult;
// import com.example.demo.service.RatingResultService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/ratings")
// @Tag(name = "Ratings", description = "Generate and fetch property ratings")
// public class RatingResultController {

//     private final RatingResultService ratingResultService;

//     public RatingResultController(RatingResultService ratingResultService) {
//         this.ratingResultService = ratingResultService;
//     }

//     @PostMapping("/generate/{propertyId}")
//     @Operation(summary = "Generate rating for a property")
//     public ResponseEntity<RatingResult> generateRating(@PathVariable Long propertyId) {
//         RatingResult result = ratingResultService.generateRating(propertyId);
//         return ResponseEntity.ok(result);
//     }

//     @GetMapping("/property/{propertyId}")
//     @Operation(summary = "Get rating result for a property")
//     public ResponseEntity<RatingResult> getRating(@PathVariable Long propertyId) {
//         RatingResult result = ratingResultService.getRating(propertyId);
//         return ResponseEntity.ok(result);
//     }
//}

// package com.example.demo.controller;

// import com.example.demo.entity.RatingResult;
// import com.example.demo.service.RatingService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/ratings")
// public class RatingController {

//     private final RatingService ratingService;

//     public RatingController(RatingService ratingService) {
//         this.ratingService = ratingService;
//     }

//     /**
//      * Triggers the rating engine to calculate and save a rating for a property.
//      * Maps to POST /ratings/generate/{propertyId}
//      */
//     @PostMapping("/generate/{propertyId}")
//     public ResponseEntity<RatingResult> generateRating(@PathVariable Long propertyId) {
//         RatingResult result = ratingService.generateRating(propertyId);
//         return new ResponseEntity<>(result, HttpStatus.CREATED);
//     }

//     /**
//      * Retrieves an existing rating result for a property.
//      * Maps to GET /ratings/property/{propertyId}
//      */
//     @GetMapping("/property/{propertyId}")
//     public ResponseEntity<RatingResult> getRating(@PathVariable Long propertyId) {
//         RatingResult result = ratingService.getRating(propertyId);
//         return ResponseEntity.ok(result);
//     }
// }



package com.example.demo.controller;

import com.example.demo.entity.RatingLog;
import com.example.demo.entity.RatingResult;
import com.example.demo.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * Generate rating for a property (ADMIN only)
     */
    @PostMapping("/generate/{propertyId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RatingResult> generateRating(@PathVariable Long propertyId) {
        RatingResult ratingResult = ratingService.generateRating(propertyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingResult);
    }

    /**
     * Get rating by property ID
     */
    @GetMapping("/property/{propertyId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public ResponseEntity<RatingResult> getRatingByPropertyId(@PathVariable Long propertyId) {
        RatingResult ratingResult = ratingService.getRatingByPropertyId(propertyId);
        return ResponseEntity.ok(ratingResult);
    }

    /**
     * Get all ratings
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public ResponseEntity<List<RatingResult>> getAllRatings() {
        List<RatingResult> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }

    /**
     * Get ratings by category
     */
    @GetMapping("/category/{category}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public ResponseEntity<List<RatingResult>> getRatingsByCategory(@PathVariable String category) {
        List<RatingResult> ratings = ratingService.getRatingsByCategory(category);
        return ResponseEntity.ok(ratings);
    }

    /**
     * Get rating logs for a property
     */
    @GetMapping("/logs/property/{propertyId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public ResponseEntity<List<RatingLog>> getRatingLogsByPropertyId(@PathVariable Long propertyId) {
        List<RatingLog> logs = ratingService.getRatingLogsByPropertyId(propertyId);
        return ResponseEntity.ok(logs);
    }

    /**
     * Get all rating logs
     */
    @GetMapping("/logs")
    @PreAuthorize("hasAnyRole('ADMIN', 'ANALYST')")
    public ResponseEntity<List<RatingLog>> getAllRatingLogs() {
        List<RatingLog> logs = ratingService.getAllRatingLogs();
        return ResponseEntity.ok(logs);
    }
}