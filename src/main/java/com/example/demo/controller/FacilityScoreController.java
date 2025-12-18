package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityService;


@RestController
public class FacilityScoreController {

    @Autowired
    FacilityScoreService fs;

    @PostMapping("/{propertyId}")
    public FacilityScore addScore(@RequestBody FacilityScore facilityscore ){
        return fs.addScore(facilityscore);
    }
    
    
    @GetMapping("{propertyId}")
    public FacilityScore getScoreByProperty(Long id) {
        return fs.getScoreByProperty(id);
    }

} 