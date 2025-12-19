package com.example.demo.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceimpls implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public Property register(User user) {
        return repo.save(user);
    }

    @Override
    public List<Property> findByemail(User user) {
        return repo.findbyemail(user);
    }
}