package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springFramework.web.bind.annotation.Ge
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityScoreService;

@RestController
public class FacilityScoreController {
    @Autowired
    FacilityService fs;

    @PostMapping("/{propertyId}")
    public  FacilityService addFacilityService(@RequestBody  FacilityService fss){
        return fss.addScore(fs);
    }

    @GetMapping("/{propertyId}")
    public int first(){
        return fss.getScoreByProperty(fs);
    } 
}