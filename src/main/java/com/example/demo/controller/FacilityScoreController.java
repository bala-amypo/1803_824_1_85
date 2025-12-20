package com.example.demo.controller;

import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityScoreService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/scores")
public class FacilityScoreController {

    private final FacilityScoreService facilityScoreService;

    public FacilityScoreController(FacilityScoreService facilityScoreService) {
        this.facilityScoreService = facilityScoreService;
    }

    
    @PostMapping("/{propertyId}")
    public FacilityScore addScore(@PathVariable Long propertyId,
                                  @Valid @RequestBody FacilityScore score) {
        return facilityScoreService.addScore(propertyId, score);
    }

  
    @GetMapping("/{propertyId}")
    public FacilityScore getScore(@PathVariable Long propertyId) {
        return facilityScoreService.getScoreByProperty(propertyId);
    }

    
    @GetMapping("/all/{propertyId}")
    public List<FacilityScore> getAllScores(@PathVariable Long propertyId) {
        return facilityScoreService.getAllScoresByProperty(propertyId);
    }
}

