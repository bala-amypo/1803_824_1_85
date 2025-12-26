package com.example.demo.service;

import com.example.demo.entity.Property;
import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);
    Property getPropertyById(Long id); // Changed from Optional to Property
    List<Property> getAllProperties();
    Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
    List<Property> searchProperties(String title);
}