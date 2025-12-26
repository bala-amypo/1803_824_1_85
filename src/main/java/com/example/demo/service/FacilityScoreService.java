
// package com.example.demo.service;

// import com.example.demo.entity.FacilityScore;

// import java.util.List;

// public interface FacilityScoreService {

//     FacilityScore createFacilityScore(FacilityScore score);

//     List<FacilityScore> getAllScores();

//     FacilityScore getScoreById(Long id);

//     List<FacilityScore> getScoresByPropertyId(Long propertyId);

//     void deleteScore(Long id);
// }


package com.example.demo.service;

import com.example.demo.entity.FacilityScore;

public interface FacilityScoreService {
    FacilityScore addScore(Long propertyId, FacilityScore score);
    FacilityScore getScoreByProperty(Long propertyId);
}
