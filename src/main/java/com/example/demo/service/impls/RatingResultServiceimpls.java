package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingResultService;

@Service
public class RatingResultServiceIimpls implements RatingResultService {

    private final RatingResultRepository ratingResultRepository;
    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;

    public RatingResultServiceimpls(RatingResultRepository ratingResultRepository,PropertyRepository propertyRepository,FacilityScoreRepository facilityScoreRepository) {
        this.ratingResultRepository = ratingResultRepository;
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
    }

    @Override
    @Transactional
    public RatingResult generateRating(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        FacilityScore score = facilityScoreRepository.findByProperty(property)
                .orElseThrow(() -> new RuntimeException("Facility score not found"));

        double finalRating = (score.getHospitalProximity() + score.getSchoolProximity() +
                              score.getTransportAccess() + score.getSafetyScore()) / 4.0;

        String category;
        if(finalRating < 4) category = "POOR";
        else if(finalRating < 6) category = "AVERAGE";
        else if(finalRating < 8) category = "GOOD";
        else category = "EXCELLENT";

        RatingResult existing = ratingResultRepository.findByProperty(property);
        if(existing != null) {
            existing.setFinalRating(finalRating);
            existing.setRatingCategory(category);
            return ratingResultRepository.save(existing);
        }

        RatingResult result = new RatingResult(property, finalRating, category);
        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRating(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        return ratingResultRepository.findByProperty(property);
    }
}


