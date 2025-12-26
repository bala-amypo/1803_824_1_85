// package com.example.demo.service;

// import com.example.demo.entity.RatingResult;

// public interface RatingResultService {
//     RatingResult generateRating(Long propertyId);
//     RatingResult getRating(Long propertyId);
//}


// package com.example.demo.service;
// import com.example.demo.entity.RatingResult;

// public interface RatingService {
//     RatingResult generateRating(Long propertyId);
//     RatingResult getRating(Long propertyId);
//}


package com.example.demo.service;

import com.example.demo.entity.RatingResult;

public interface RatingService {
    /**
     * Calculates the average score and assigns a category.
     */
    RatingResult generateRating(Long propertyId);

    /**
     * Retrieves an existing rating result for a property.
     */
    RatingResult getRating(Long propertyId);
}