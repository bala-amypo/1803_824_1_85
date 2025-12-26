package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
import java.util.List;

public interface FacilityScoreService {
    List<FacilityScore> getAllScoresByProperty(Long propertyId);
    FacilityScore getScoreByProperty(Long propertyId);
    FacilityScore saveScore(FacilityScore score);
}