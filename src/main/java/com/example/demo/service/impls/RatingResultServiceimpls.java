package com.example.demo.service.impls;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.repository.RatingResultRepository;
import com.example.demo.service.RatingResultService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RatingResultServiceimpls implements RatingResultService {

    private final PropertyRepository propertyRepository;
    private final FacilityScoreRepository facilityScoreRepository;
    private final RatingResultRepository ratingResultRepository;

    public RatingResultServiceimpls(PropertyRepository propertyRepository,
                                    FacilityScoreRepository facilityScoreRepository,
                                    RatingResultRepository ratingResultRepository) {
        this.propertyRepository = propertyRepository;
        this.facilityScoreRepository = facilityScoreRepository;
        this.ratingResultRepository = ratingResultRepository;
    }

    @Override
    public RatingResult generateRating(Long propertyId) {

        Optional<Property> propertyOpt = propertyRepository.findById(propertyId);
        if (!propertyOpt.isPresent()) {
            return null;
        }

        Optional<FacilityScore> scoreOpt =
                facilityScoreRepository.findByPropertyId(propertyId);

        if (!scoreOpt.isPresent()) {
            return null;
        }

        FacilityScore score = scoreOpt.get();

        double avg = (
                score.getSchoolProximity()
                        + score.getHospitalProximity()
                        + score.getTransportAccess()
                        + score.getSafetyScore()
        ) / 4.0;

        Optional<RatingResult> ratingOpt =
                ratingResultRepository.findByPropertyId(propertyId);

        RatingResult result = ratingOpt.isPresent()
                ? ratingOpt.get()
                : new RatingResult();

        result.setProperty(propertyOpt.get());
        result.setFinalRating(avg);
        result.setRatingCategory(resolveCategory(avg));

        return ratingResultRepository.save(result);
    }

    @Override
    public RatingResult getRatingByProperty(Long propertyId) {
        Optional<RatingResult> ratingOpt =
                ratingResultRepository.findByPropertyId(propertyId);

        return ratingOpt.orElse(null);
    }

    private String resolveCategory(double rating) {
        if (rating >= 8) return "EXCELLENT";
        if (rating >= 6) return "GOOD";
        if (rating >= 4) return "AVERAGE";
        return "POOR";
    }
}