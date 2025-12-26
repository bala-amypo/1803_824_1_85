package com.example.demo.service.impls;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.FacilityScoreService;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacilityScoreServiceimpls implements FacilityScoreService {

    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreServiceimpls(FacilityScoreRepository facilityScoreRepository,
                                     PropertyRepository propertyRepository) {
        this.facilityScoreRepository = facilityScoreRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public FacilityScore createFacilityScore(FacilityScore score) {
        Long propertyId = score.getProperty().getId();
        Optional<Property> propertyOpt = propertyRepository.findById(propertyId);

        if(propertyOpt.isPresent()) {
            score.setProperty(propertyOpt.get());
            return facilityScoreRepository.save(score);
        }
        throw new RuntimeException("Property not found with id " + propertyId);
    }

    @Override
    public List<FacilityScore> getAllScores() {
        return facilityScoreRepository.findAll();
    }

    @Override
    public FacilityScore getScoreById(Long id) {
        return facilityScoreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FacilityScore not found with id " + id));
    }

    @Override
    public List<FacilityScore> getScoresByPropertyId(Long propertyId) {
        return facilityScoreRepository.findAllByProperty_Id(propertyId);
    }

    @Override
    public void deleteScore(Long id) {
        facilityScoreRepository.deleteById(id);
    }
}
