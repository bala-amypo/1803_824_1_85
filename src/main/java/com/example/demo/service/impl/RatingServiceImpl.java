package com.example.demo.service.impl;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingResultRepository ratingResultRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    // Constructor Injection (No @RequiredArgsConstructor needed)
    public RatingServiceImpl(RatingResultRepository ratingResultRepository,
                             FacilityScoreRepository facilityScoreRepository,
                             PropertyRepository propertyRepository) {
        this.ratingResultRepository = ratingResultRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    @Transactional
    public RatingResult generateRating(Long propertyId) {
        // 1. Find Property
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));

        // 2. Find Facility Score
        FacilityScore score = facilityScoreRepository.findByProperty(property)
                .orElseThrow(() -> new BadRequestException("Facility scores must be provided before generating a rating."));

        // 3. Calculate Average
        double average = (score.getSchoolProximity() + 
                          score.getHospitalProximity() + 
                          score.getTransportAccess() + 
                          score.getSafetyScore()) / 4.0;

        // 4. Check if a rating already exists for this property to update it, or create a new one
        // Note: This requires your Repository to return Optional<RatingResult>
        RatingResult result = ratingResultRepository.findByProperty(property)
                .orElse(new RatingResult());

        result.setProperty(property);
        result.setFinalRating(average);

        // 5. Threshold Logic
        if (average >= 8.0) {
            result.setRatingCategory("EXCELLENT");
        } else if (average >= 6.0) {
            result.setRatingCategory("GOOD");
        } else if (average >= 4.0) {
            result.setRatingCategory("AVERAGE");
        } else {
            result.setRatingCategory("POOR");
        }

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRating(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        // Use Optional handling to avoid the "cannot find symbol: orElseThrow" error
        return ratingResultRepository.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("No rating result found for this property."));
    }
}