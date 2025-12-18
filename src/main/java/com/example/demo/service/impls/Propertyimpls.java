package com.example.demo.controller;

import java.util.List;
import org.Springframwork.beans.factory.annotation.Autowired;
import org.Springframwork.stereotype.Service;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;

@Service
public class Propertyimpl implements PropertyService {

    @Autowired
    private PropertyRepository repo;

    @Override
    public Property addProperty(Property property) {
        return repo.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return repo.findAll();
    }
}