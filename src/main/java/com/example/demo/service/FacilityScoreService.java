package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
import java.util.List;

public interface FacilityScoreService {
    FacilityScore addScore(Long propertyId, FacilityScore score); // Added for Controller
    List<FacilityScore> getAllScoresByProperty(Long propertyId);
    FacilityScore getScoreByProperty(Long propertyId);
}