
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.FacilityScore;

public interface FacilityScoreService {
    FacilityScore addScore(Property property);
    List<Property> getScoreByProperties();
}
