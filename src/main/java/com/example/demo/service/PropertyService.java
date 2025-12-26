package com.example.demo.service;

import com.example.demo.entity.Property;
import java.util.List;

public interface PropertyService {
    Property createProperty(Property property); // Matches Controller
    Property getPropertyById(Long id);
    List<Property> getAllProperties();
    Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
    List<Property> searchProperties(String title);
}