
package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Property;

public interface PropertyService {
    Property addProperty(Property property);
    List<Property> getAllProperties();
}
