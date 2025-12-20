
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.FacilityScore;

public interface FacilityScoreService {
    FacilityScore addScore(Long propertyId,FacilityScore score);
    List<Property> getScoreByProperty(Long propertyId);
}
