

// package com.example.demo.service.impls;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.entity.Property;
// import com.example.demo.service.PropertyService;

// import java.util.List;

// @Service
// public class PropertyServiceimpls implements PropertyService {  // make class name consistent

//     @Autowired
//     private PropertyRepository repository;

//     @Override
//     public Property createProperty(Property property) {
//         return repository.save(property);
//     }

//     @Override
//     public List<Property> getAllProperties() {
//         return repository.findAll();
//     }

//     @Override
//     public Property getPropertyById(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Property not found with id " + id));
//     }

//     @Override
//     public Property updateProperty(Long id, Property property) {
//         Property existing = getPropertyById(id);
//         existing.setName(property.getName());
//         return repository.save(existing);
//     }

//     @Override
//     public void deleteProperty(Long id) {
//         Property existing = getPropertyById(id);
//         repository.delete(existing);
//     }
// }


// package com.example.demo.service.impl;

// import com.example.demo.entity.Property;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.PropertyService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class PropertyServiceImpl implements PropertyService {
//     private final PropertyRepository propertyRepository;
//     public PropertyServiceImpl(PropertyRepository pr) { this.propertyRepository = pr; }

//     @Override
//     public Property addProperty(Property property) {
//         if (property.getPrice() < 0) throw new BadRequestException("Price must be >= 0");
//         if (property.getAreaSqFt() < 100) throw new BadRequestException("Area must be >= 100");
//         return propertyRepository.save(property);
//     }

//     @Override
//     public List<Property> getAllProperties() {
//         return propertyRepository.findAll();
//     }
// }


// package com.example.demo.service.impl;

// import com.example.demo.entity.Property;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.PropertyService;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;
// import java.util.Optional;

// @Service
// @Transactional
// public class PropertyServiceImpl implements PropertyService {

//     private final PropertyRepository propertyRepository;

//     public PropertyServiceImpl(PropertyRepository propertyRepository) {
//         this.propertyRepository = propertyRepository;
//     }

//     @Override
//     public Property addProperty(Property property) {
//         return propertyRepository.save(property);
//     }

//     @Override
//     public Optional<Property> getPropertyById(Long id) {
//         return propertyRepository.findById(id);
//     }

//     @Override
//     public List<Property> getAllProperties() {
//         return propertyRepository.findAll();
//     }

//     @Override
//     public Property updateProperty(Long id, Property property) {
//         Property existing = propertyRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Property not found"));
//         existing.setTitle(property.getTitle());
//         existing.setAddress(property.getAddress());
//         existing.setCity(property.getCity());
//         existing.setPrice(property.getPrice());
//         existing.setAreaSqFt(property.getAreaSqFt());
//         return propertyRepository.save(existing);
//     }

//     @Override
//     public void deleteProperty(Long id) {
//         Property property = propertyRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Property not found"));
//         propertyRepository.delete(property);
//     }
// }



// package com.example.demo.service.impl;

// import com.example.demo.entity.Property;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.PropertyService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class PropertyServiceImpl implements PropertyService {

//     @Autowired
//     private PropertyRepository propertyRepository;

//     @Override
//     public Property addProperty(Property property) {
//         return propertyRepository.save(property);
//     }
// }
