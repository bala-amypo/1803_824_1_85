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


// package com.example.demo.service;

// import com.example.demo.entity.RatingResult;

// public interface RatingService {
//     /**
//      * Calculates the average score and assigns a category.
//      */
//     RatingResult generateRating(Long propertyId);

//     /**
//      * Retrieves an existing rating result for a property.
//      */
//     RatingResult getRating(Long propertyId);
// }


// package com.example.demo.service;

// import com.example.demo.entity.FacilityScore;
// import com.example.demo.entity.Property;
// import com.example.demo.entity.RatingLog;
// import com.example.demo.entity.RatingResult;
// import com.example.demo.repository.FacilityScoreRepository;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.repository.RatingLogRepository;
// import com.example.demo.repository.RatingResultRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;

// @Service
// @Transactional
// public class RatingService {

//     @Autowired
//     private PropertyRepository propertyRepository;

//     @Autowired
//     private FacilityScoreRepository facilityScoreRepository;

//     @Autowired
//     private RatingResultRepository ratingResultRepository;

//     @Autowired
//     private RatingLogRepository ratingLogRepository;

//     /**
//      * Generate rating for a property based on facility scores
//      */
//     public RatingResult generateRating(Long propertyId) {
//         Property property = propertyRepository.findById(propertyId)
//                 .orElseThrow(() -> new RuntimeException("Property not found with id: " + propertyId));

//         FacilityScore facilityScore = facilityScoreRepository.findByProperty(property)
//                 .orElseThrow(() -> new RuntimeException("Facility score not found for property id: " + propertyId));

//         // Calculate average rating from facility scores
//         Double averageScore = facilityScore.calculateAverageScore();

//         // Determine rating category
//         String category = RatingResult.determineCategory(averageScore);

//         // Create or update rating result
//         RatingResult ratingResult = ratingResultRepository.findByProperty(property)
//                 .orElse(new RatingResult());

//         ratingResult.setProperty(property);
//         ratingResult.setFinalRating(averageScore);
//         ratingResult.setRatingCategory(category);

//         RatingResult savedResult = ratingResultRepository.save(ratingResult);

//         // Create rating log
//         RatingLog log = new RatingLog();
//         log.setProperty(property);
//         log.setMessage(String.format("Rating generated: %.2f (%s) - School: %d, Hospital: %d, Transport: %d, Safety: %d",
//                 averageScore, category,
//                 facilityScore.getSchoolProximity(),
//                 facilityScore.getHospitalProximity(),
//                 facilityScore.getTransportAccess(),
//                 facilityScore.getSafetyScore()));
//         ratingLogRepository.save(log);

//         return savedResult;
//     }

//     /**
//      * Get rating result by property ID
//      */
//     public RatingResult getRatingByPropertyId(Long propertyId) {
//         return ratingResultRepository.findByPropertyId(propertyId)
//                 .orElseThrow(() -> new RuntimeException("Rating not found for property id: " + propertyId));
//     }

//     /**
//      * Get all ratings
//      */
//     public List<RatingResult> getAllRatings() {
//         return ratingResultRepository.findAll();
//     }

//     /**
//      * Get ratings by category
//      */
//     public List<RatingResult> getRatingsByCategory(String category) {
//         return ratingResultRepository.findByRatingCategory(category);
//     }

//     /**
//      * Get rating logs for a property
//      */
//     public List<RatingLog> getRatingLogsByPropertyId(Long propertyId) {
//         return ratingLogRepository.findByPropertyId(propertyId);
//     }

//     /**
//      * Get all rating logs
//      */
//     public List<RatingLog> getAllRatingLogs() {
//         return ratingLogRepository.findAll();
//     }
// }

// package com.example.demo.service;

// import com.example.demo.entity.Property;
// import com.example.demo.entity.RatingResult;

// import java.util.Optional;

// public interface RatingService {

//     RatingResult generateRating(Property property);

//     Optional<RatingResult> getRatingByProperty(Property property);
// }
