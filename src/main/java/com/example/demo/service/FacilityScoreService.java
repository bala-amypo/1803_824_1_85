package com.example.demo.service;

import com.example.demo.entity.FacilityScore;
public interface FacilityScoreService{
    void  FacilityScore addScore(Long propertyId, FacilityScore score);
    int  FacilityScore getScoreByProperty(Long propertyId);
}