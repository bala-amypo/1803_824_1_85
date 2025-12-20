
// package com.example.demo.service;

// import com.example.demo.entity.FacilityScore;
// import java.util.List;

// public interface FacilityScoreService {

//     FacilityScore addScore(Long propertyId, FacilityScore score);

//     FacilityScore getScoreByProperty(Long propertyId);

//     List<FacilityScore> getAllScoresByProperty(Long propertyId);
// }

package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
import java.util.List;

public interface FacilityScoreService {

    FacilityScore addScore(Long propertyId, FacilityScore score);

    FacilityScore getScoreByProperty(Long propertyId);

    List<FacilityScore> getAllScoresByProperty(Long propertyId);
}