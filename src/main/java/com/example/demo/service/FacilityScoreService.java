
// package com.example.demo.service;

// import com.example.demo.entity.FacilityScore;

// import java.util.List;

// public interface FacilityScoreService {

//     FacilityScore createFacilityScore(FacilityScore score);

//     List<FacilityScore> getAllScores();

//     FacilityScore getScoreById(Long id);

//     List<FacilityScore> getScoresByPropertyId(Long propertyId);

//     void deleteScore(Long id);
//}


// package com.example.demo.service.impl;

// import com.example.demo.entity.Property;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.PropertyService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class PropertyServiceImpl implements PropertyService {
//     private final PropertyRepository propertyRepository;
//     public PropertyServiceImpl(PropertyRepository pr) { this.propertyRepository = pr; }

//     @Override
//     public Property addProperty(Property property) {
//        if (property.getPrice() < 0) throw new BadRequestException("Price must be >= 0");
//         if (property.getAreaSqFt() < 100) throw new BadRequestException("Area must be >= 100");
//         return propertyRepository.save(property);
//     }

//     @Override
//     public List<Property> getAllProperties() {
//         return propertyRepository.findAll();
//     }
//}


// package com.example.demo.service;
// import com.example.demo.entity.FacilityScore;

// public interface FacilityScoreService {
//     FacilityScore addScore(Long propertyId, FacilityScore score);
//     FacilityScore getScoreByProperty(Long propertyId);
// }


package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;

import java.util.Optional;

public interface FacilityScoreService {

    FacilityScore addScore(Property property, FacilityScore score);

    Optional<FacilityScore> getScoreByProperty(Property property);
}

