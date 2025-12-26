// package com.example.demo.service.impls;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import com.example.demo.entity.FacilityScore;
// import com.example.demo.entity.Property;
// import com.example.demo.entity.RatingResult;
// import com.example.demo.repository.FacilityScoreRepository;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.repository.RatingResultRepository;
// import com.example.demo.service.RatingResultService;

// @Service
// public class RatingResultServiceimpls implements RatingResultService {

//     private final RatingResultRepository ratingResultRepository;
//     private final PropertyRepository propertyRepository;
//     private final FacilityScoreRepository facilityScoreRepository;

//     public RatingResultServiceimpls(RatingResultRepository ratingResultRepository,PropertyRepository propertyRepository,FacilityScoreRepository facilityScoreRepository) {
//         this.ratingResultRepository = ratingResultRepository;
//         this.propertyRepository = propertyRepository;
//         this.facilityScoreRepository = facilityScoreRepository;
//     }

//     @Override
//     @Transactional
//     public RatingResult generateRating(Long propertyId) {
//         Property property = propertyRepository.findById(propertyId)
//                .orElseThrow(() -> new RuntimeException("Property not found"));

//         FacilityScore score = facilityScoreRepository.findByProperty(property)
//                 .orElseThrow(() -> new RuntimeException("Facility score not found"));

//         double finalRating = (score.getHospitalProximity() + score.getSchoolProximity() +
//                               score.getTransportAccess() + score.getSafetyScore()) / 4.0;

//         String category;
//         if(finalRating < 4) category = "POOR";
//         else if(finalRating < 6) category = "AVERAGE";
//         else if(finalRating < 8) category = "GOOD";
//         else category = "EXCELLENT";

//         RatingResult existing = ratingResultRepository.findByProperty(property);
//         if(existing != null) {
//            existing.setFinalRating(finalRating);
//             existing.setRatingCategory(category);
//             return ratingResultRepository.save(existing);
//         }

//         RatingResult result = new RatingResult(property, finalRating, category);
//         return ratingResultRepository.save(result);
//     }

//     @Override
//     public RatingResult getRating(Long propertyId) {
//         Property property = propertyRepository.findById(propertyId)
//                .orElseThrow(() -> new RuntimeException("Property not found"));
//         return ratingResultRepository.findByProperty(property);
//     }
//}


package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingResultRepository ratingResultRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    public RatingServiceImpl(RatingResultRepository rr, FacilityScoreRepository fs, PropertyRepository pr) {
        this.ratingResultRepository = rr; this.facilityScoreRepository = fs; this.propertyRepository = pr;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {
        Property p = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        FacilityScore s = facilityScoreRepository.findByProperty(p)
                .orElseThrow(() -> new BadRequestException("Missing Facility Score"));

        double avg = (s.getSchoolProximity() + s.getHospitalProximity() + s.getTransportAccess() + s.getSafetyScore()) / 4.0;
        
        RatingResult result = new RatingResult();
        result.setProperty(p);
        result.setFinalRating(avg);
        
        if (avg >= 8) result.setRatingCategory("EXCELLENT");
        else if (avg >= 6) result.setRatingCategory("GOOD");
        else if (avg >= 4) result.setRatingCategory("AVERAGE");
        else result.setRatingCategory("POOR");

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRating(Long propertyId) {
        Property p = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
        return ratingResultRepository.findByProperty(p)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found"));
    }
}

