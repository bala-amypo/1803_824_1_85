package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityScoreService;

@RestController
public class FacilityScoreController {
    @Autowired
     private FacilityService fss;

    @PostMapping("/{propertyId}")
    public  FacilityService addFacilityService(@RequestBody  FacilityService fss){
        return fs.addScore(fss);
    }

    @GetMapping("/{propertyId}")
    public int first(){
        return fs.first();
    } 
}