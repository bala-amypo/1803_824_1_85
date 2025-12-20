// // package com.example.demo.service.impls;

// // import com.example.demo.entity.FacilityScore;
// // import com.example.demo.entity.Property;
// // import com.example.demo.repository.FacilityScoreRepository;
// // import com.example.demo.repository.PropertyRepository;
// // import com.example.demo.service.FacilityScoreService;
// // import org.springframework.stereotype.Service;
// // import java.util.List;

// // @Service
// // public class FacilityScoreServiceimpls implements FacilityScoreService {

// //     private final FacilityScoreRepository facilityScoreRepository;
// //     private final PropertyRepository propertyRepository;

// //     public FacilityScoreServiceimpls(FacilityScoreRepository facilityScoreRepository,PropertyRepository propertyRepository) {
// //         this.facilityScoreRepository = facilityScoreRepository;
// //         this.propertyRepository = propertyRepository;
// //     }

// //     @Override
// //     public FacilityScore addScore(Long propertyId, FacilityScore score) {
// //         Property property = propertyRepository.findById(propertyId)
// //                 .orElseThrow(() -> new RuntimeException("Property not found"));

        
// //         FacilityScore existing = facilityScoreRepository.findByPropertyId(propertyId);
// //         if (existing != null) {
// //             throw new RuntimeException("Facility score already exists for this property");
// //         }

// //         score.setProperty(property);
// //         return facilityScoreRepository.save(score);
// //     }

// //     @Override
// //     public FacilityScore getScoreByProperty(Long propertyId) {
// //         return facilityScoreRepository.findByPropertyId(propertyId);
// //     }

// //     @Override
// //     public List<FacilityScore> getAllScoresByProperty(Long propertyId) {
// //         return facilityScoreRepository.findAllByPropertyId(propertyId);
// //     }
// // }

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

//     public FacilityScoreServiceimpls(FacilityScoreRepository facilityScoreRepository,
//                                     PropertyRepository propertyRepository) {
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

package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.FacilityScoreRepository;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;
import com.example.demo.service.FacilityScoreService;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityScoreServiceImpl implements FacilityScoreService {

    @Autowired
    private FacilityScoreRepository facilityScoreRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public FacilityScore createFacilityScore(FacilityScore score) {
        Long propertyId = score.getProperty().getId();
        Optional<Property> property = propertyRepository.findById(propertyId);
        if(property.isPresent()) {
            score.setProperty(property.get());
            return facilityScoreRepository.save(score);
        } else {
            throw new RuntimeException("Property not found with id " + propertyId);
        }
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
        return facilityScoreRepository.findByPropertyId(propertyId);
    }

    @Override
    public void deleteScore(Long id) {
        facilityScoreRepository.deleteById(id);
    }
}