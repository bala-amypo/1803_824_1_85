package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityService;

@RestController
public class FacilityScoreController {
    @Autowired
    FacilityService fs;
    

    @PostMapping("/register")
    public FacilityScore addfacility(@RequestBody User fss){
        return fs.addScore(fss);
    }

    @PostMapping("/login")
    public FacilityScore addsfacility(@RequestBody User uss){
        return fs.getScore(fss);
    }

    
}