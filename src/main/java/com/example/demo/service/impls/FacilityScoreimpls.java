package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FacilityScore;
import com.example.demo.repository.FacilityScoreRepository;

@Service
public class FacilityScoreImpl implements FacilityScoreService {

    @Autowired
    private FacilityScoreRepository repository;

    
    public FacilityScore addScore(FacilityScore score) {
        return repository.save(score);
    }

   
    public FacilityScore getScoreById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("FacilityScore not found with id: " + id));
    }
}
