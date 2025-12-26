
// // package com.example.demo.service;

// // import com.example.demo.entity.Property;
// // import java.util.List;

// // public interface PropertyService {
// //     Property createProperty(Property property);          
// //     List<Property> getAllProperties();
// //     Property getPropertyById(Long id);
// //     Property updateProperty(Long id, Property property);
// //     void deleteProperty(Long id);
// // }


// // package com.example.demo.service;
// // import com.example.demo.entity.Property;
// // import java.util.List;

// // public interface PropertyService {
// //     Property addProperty(Property property);
// //     List<Property> getAllProperties();
// //}


// package com.example.demo.service;

// import com.example.demo.entity.Property;
// import com.example.demo.repository.PropertyRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;

// @Service
// @Transactional
// public class PropertyService {

//     @Autowired
//     private PropertyRepository propertyRepository;

//     /**
//      * Add a new property
//      */
//     public Property addProperty(Property property) {
//         return propertyRepository.save(property);
//     }

//     /**
//      * Get all properties
//      */
//     public List<Property> getAllProperties() {
//         return propertyRepository.findAll();
//     }

//     /**
//      * Get property by ID
//      */
//     public Property getPropertyById(Long id) {
//         return propertyRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Property not found with id: " + id));
//     }

//     /**
//      * Update property
//      */
//     public Property updateProperty(Long id, Property propertyDetails) {
//         Property property = getPropertyById(id);
        
//         property.setTitle(propertyDetails.getTitle());
//         property.setAddress(propertyDetails.getAddress());
//         property.setCity(propertyDetails.getCity());
//         property.setPrice(propertyDetails.getPrice());
//         property.setAreaSqFt(propertyDetails.getAreaSqFt());
        
//         return propertyRepository.save(property);
//     }

//     /**
//      * Delete property
//      */
//     public void deleteProperty(Long id) {
//         Property property = getPropertyById(id);
//         propertyRepository.delete(property);
//     }

//     /**
//      * Find properties by city
//      */
//     public List<Property> getPropertiesByCity(String city) {
//         return propertyRepository.findByCity(city);
//     }

//     /**
//      * Find properties by city using HQL
//      */
//     public List<Property> getPropertiesByCityHql(String city) {
//         return propertyRepository.findByCityHql(city);
//     }

//     /**
//      * Search properties by title
//      */
//     public List<Property> searchPropertiesByTitle(String keyword) {
//         return propertyRepository.findByTitleContainingIgnoreCase(keyword);
//     }
// }



// package com.example.demo.service;

// import com.example.demo.entity.Property;
// import java.util.List;
// import java.util.Optional;

// public interface PropertyService {
//     Property addProperty(Property property);
//     Optional<Property> getPropertyById(Long id);
//     List<Property> getAllProperties();
//     Property updateProperty(Long id, Property property);
//     void deleteProperty(Long id);
// }


package com.example.demo.service;

import com.example.demo.entity.Property;

public interface PropertyService {
    Property addProperty(Property property);
}


