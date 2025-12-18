package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class AuthController {
    @Autowired
    UserService us;

    @PostMapping("/Register")
    public User addUser(@RequestBody User us){
        return us.logEvent(atr);
    }

    
}