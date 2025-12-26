
package com.example.demo.service;

import com.example.demo.entity.Property;
import java.util.List;

public interface PropertyService {
    Property createProperty(Property property);          
    List<Property> getAllProperties();
    Property getPropertyById(Long id);
    Property updateProperty(Long id, Property property);
    void deleteProperty(Long id);
}

