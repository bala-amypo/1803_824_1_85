package com.example.demo.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceimpls implements UserService {

    @Autowired
    public UserRepository repo;

    @Override
    public User register(User user) {
        return repo.save(user);
    }

    @Override
    public User (String email) {
        return repo.findByEmail(email);
    }
}