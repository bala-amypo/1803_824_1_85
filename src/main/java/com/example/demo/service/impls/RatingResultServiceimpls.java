package com.example.demo.service.impls;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.RatingResultRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.entity.RatingResult;
import com.example.demo.entity.Property;
import com.example.demo.exception.RatingResultRuntimeException;
import com.example.demo.service.RatingResultService;

import java.util.List;

@Service
public class RatingResultServiceimpls implements RatingResultService {

    @Autowired
    private RatingResultRepository ratingResultRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public RatingResult createRatingResult(RatingResult ratingResult) {
        Long propertyId = ratingResult.getProperty().getId();

        if (!propertyRepository.existsById(propertyId)) {
            throw new RatingResultRuntimeException("Property not found with id: " + propertyId);
        }

        if (ratingResultRepository.existsByPropertyId(propertyId)) {
            throw new RatingResultRuntimeException("Rating already exists for property id: " + propertyId);
        }

        Property property = propertyRepository.findById(propertyId).get();
        ratingResult.setProperty(property);
        return ratingResultRepository.save(ratingResult);
    }

    @Override
    public RatingResult getRatingResultById(Long id) {
        return ratingResultRepository.findById(id)
                .orElseThrow(() -> new RatingResultRuntimeException("RatingResult not found with id: " + id));
    }

    @Override
    public List<RatingResult> getAllRatingResults() {
        return ratingResultRepository.findAll();
    }

    @Override
    public RatingResult updateRatingResult(Long id, RatingResult ratingResult) {
        RatingResult existing = getRatingResultById(id);

        existing.setFinalRating(ratingResult.getFinalRating());
        existing.setRatingCategory(ratingResult.getRatingCategory());
        // Do not change property as it is OneToOne unique

        return ratingResultRepository.save(existing);
    }

    @Override
    public void deleteRatingResult(Long id) {
        RatingResult existing = getRatingResultById(id);
        ratingResultRepository.delete(existing);
    }
}
