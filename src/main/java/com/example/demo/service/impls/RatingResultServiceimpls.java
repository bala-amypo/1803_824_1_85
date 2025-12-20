package com.example.demo.service.impls;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingResultService;
import org.springframework.stereotype.Service;

@Service
public class RatingResultServiceimpls implements RatingResultService {

    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingResultRepository ratingResultRepository;

    public RatingResultServiceImpl(PropertyRepository propertyRepository,
                                   FacilityScoreRepository facilityScoreRepository,
                                   RatingResultRepository ratingResultRepository) {
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.ratingResultRepository = ratingResultRepository;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        FacilityScore score = facilityScoreRepository.findByPropertyId(propertyId)
                .orElseThrow(() -> new RuntimeException("FacilityScore not found"));

        double average = (
                score.getSchoolProximity()
                        + score.getHospitalProximity()
                        + score.getTransportAccess()
                        + score.getSafetyScore()
        ) / 4.0;

        RatingResult result = ratingResultRepository
                .findByPropertyId(propertyId)
                .orElse(new RatingResult());

        result.setProperty(property);
        result.setFinalRating(average);
        result.setRatingCategory(getCategory(average));

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRatingByProperty(Long propertyId) {
        return ratingResultRepository.findByPropertyId(propertyId)
                .orElseThrow(() -> new RuntimeException("RatingResult not found"));
    }

    private String getCategory(double rating) {
        if (rating >= 8) return "EXCELLENT";
        if (rating >= 6) return "GOOD";
        if (rating >= 4) return "AVERAGE";
        return "POOR";
    }
}

