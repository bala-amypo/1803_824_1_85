// package com.example.demo.service.impls;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.Property;
// import com.example.demo.repository.PropertyRepository;
// import com.example.demo.service.PropertyService;

// @Service
// public class PropertyServiceimpls implements PropertyService {

//     @Autowired
//     private PropertyRepository repo;

//     @Override
//     public Property addProperty(Property property) {
//         return repo.save(property);
//     }

//     @Override
//     public List<Property> getAllProperties() {
//         return repo.findAll();
//     }
//}

package com.example.demo.service.impls;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

import java.util.List;

@Service
public class PropertyServiceimpls implements PropertyService {

    @Autowired
    private PropertyRepository repository;

    @Override
    public Property createProperty(Property property) {
        return repository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return repository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found with id " + id));
    }

    @Override
    public Property updateProperty(Long id, Property property) {
        Property existing = getPropertyById(id);  // fetch existing
        existing.setName(property.getName());     // update fields
        return repository.save(existing);
    }

    @Override
    public void deleteProperty(Long id) {
        Property existing = getPropertyById(id);  // ensure it exists
        repository.delete(existing);
    }
}
