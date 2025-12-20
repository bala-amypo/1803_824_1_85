// package com.example.demo.service.impls;

// import com.example.demo.entity.FacilityScore;
// import com.example.demo.entity.Property;
// import com.example.demo.repository.FacilityScoreRepository;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.FacilityScoreService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class FacilityScoreServiceimpls implements FacilityScoreService {

//     private final FacilityScoreRepository facilityScoreRepository;
//     private final PropertyRepository propertyRepository;

//     public FacilityScoreServiceimpls(FacilityScoreRepository facilityScoreRepository,PropertyRepository propertyRepository) {
//         this.facilityScoreRepository = facilityScoreRepository;
//         this.propertyRepository = propertyRepository;
//     }

//     @Override
//     public FacilityScore addScore(Long propertyId, FacilityScore score) {
//         Property property = propertyRepository.findById(propertyId)
//                 .orElseThrow(() -> new RuntimeException("Property not found"));

        
//         FacilityScore existing = facilityScoreRepository.findByPropertyId(propertyId);
//         if (existing != null) {
//             throw new RuntimeException("Facility score already exists for this property");
//         }

//         score.setProperty(property);
//         return facilityScoreRepository.save(score);
//     }

//     @Override
//     public FacilityScore getScoreByProperty(Long propertyId) {
//         return facilityScoreRepository.findByPropertyId(propertyId);
//     }

//     @Override
//     public List<FacilityScore> getAllScoresByProperty(Long propertyId) {
//         return facilityScoreRepository.findAllByPropertyId(propertyId);
//     }
// }

package com.example.demo.service.impls;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.FacilityScoreService;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public FacilityScore addScore(Long propertyId, FacilityScore score) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        
        FacilityScore existing = facilityScoreRepository.findByPropertyId(propertyId);
        if (existing != null) {
            throw new RuntimeException("Facility score already exists for this property");
        }

        score.setProperty(property);
        return facilityScoreRepository.save(score);
    }

    @Override
    public FacilityScore getScoreByProperty(Long propertyId) {
        return facilityScoreRepository.findByPropertyId(propertyId);
    }

    @Override
    public List<FacilityScore> getAllScoresByProperty(Long propertyId) {
        return facilityScoreRepository.findAllByPropertyId(propertyId);
    }
}
