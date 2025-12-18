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
    UserService us;
    

    @PostMapping("/register")
    public User addUser(@RequestBody User as){
        return us.addScore(as);
    }

    @PostMapping("/login")
    public User addUser(@RequestBody User as){
        return us.getScore(as);
    }

    
}