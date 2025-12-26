
// package com.example.demo.service;

// import com.example.demo.entity.Property;
// import java.util.List;

// public interface PropertyService {
//     Property createProperty(Property property);          
//     List<Property> getAllProperties();
//     Property getPropertyById(Long id);
//     Property updateProperty(Long id, Property property);
//     void deleteProperty(Long id);
// }


package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Property;

public interface PropertyService {
    Property addProperty(Property property);
    List<Property> getAllProperties();
}
