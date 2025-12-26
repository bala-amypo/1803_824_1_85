package com.example.demo.service.impl;

import com.example.demo.entity.Property;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    // Fixes the Integration Test error
    @Override
    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found"));
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property updateProperty(Long id, Property property) {
        Property existing = getPropertyById(id);
        existing.setTitle(property.getTitle());
        // Add other field updates here (e.g., existing.setCity(property.getCity()))
        return propertyRepository.save(existing);
    }

    @Override
    public void deleteProperty(Long id) {
        Property existing = getPropertyById(id);
        propertyRepository.delete(existing);
    }

    @Override
    public List<Property> searchProperties(String title) {
        return propertyRepository.findByTitleContainingIgnoreCase(title);
    }
}