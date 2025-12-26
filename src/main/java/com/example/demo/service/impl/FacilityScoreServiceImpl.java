// package com.example.demo.service.impls;

// import com.example.demo.entity.FacilityScore;
// import com.example.demo.entity.Property;
// import com.example.demo.repository.FacilityScoreRepository;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.FacilityScoreService;

// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class FacilityScoreServiceimpls implements FacilityScoreService {

//     private final FacilityScoreRepository facilityScoreRepository;
//     private final PropertyRepository propertyRepository;

//     public FacilityScoreServiceimpls(FacilityScoreRepository facilityScoreRepository,
//                                      PropertyRepository propertyRepository) {
//         this.facilityScoreRepository = facilityScoreRepository;
//         this.propertyRepository = propertyRepository;
//     }

//     @Override
//     public FacilityScore createFacilityScore(FacilityScore score) {
//         Long propertyId = score.getProperty().getId();
//         Optional<Property> propertyOpt = propertyRepository.findById(propertyId);

//         if(propertyOpt.isPresent()) {
//             score.setProperty(propertyOpt.get());
//             return facilityScoreRepository.save(score);
//         }
//         throw new RuntimeException("Property not found with id " + propertyId);
//     }

//     @Override
//     public List<FacilityScore> getAllScores() {
//         return facilityScoreRepository.findAll();
//     }

//     @Override
//     public FacilityScore getScoreById(Long id) {
//         return facilityScoreRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("FacilityScore not found with id " + id));
//     }

//     @Override
//     public List<FacilityScore> getScoresByPropertyId(Long propertyId) {
//         return facilityScoreRepository.findAllByProperty_Id(propertyId);
//     }

//     @Override
//     public void deleteScore(Long id) {
//         facilityScoreRepository.deleteById(id);
//     }
//}



package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.*;
import com.example.demo.repository.*;
import com.example.demo.service.FacilityScoreService;
import org.springframework.stereotype.Service;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {
    private final FacilityScoreRepository facilityScoreRepository;
    private final PropertyRepository propertyRepository;

    public FacilityScoreServiceImpl(FacilityScoreRepository fs, PropertyRepository pr) {
        this.facilityScoreRepository = fs; this.propertyRepository = pr;
    }

    @Override
    public FacilityScore addScore(Long propertyId, FacilityScore score) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));

        if (facilityScoreRepository.findByProperty(property).isPresent()) {
            throw new BadRequestException("Score already exists for this property");
        }
        
        score.setProperty(property);
        // saveAndFlush ensures Constraints are checked immediately for the tests
        return facilityScoreRepository.saveAndFlush(score);
    }

    @Override
    public FacilityScore getScoreByProperty(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return facilityScoreRepository.findByProperty(property)
                .orElseThrow(() -> new ResourceNotFoundException("Score missing"));
    }
}