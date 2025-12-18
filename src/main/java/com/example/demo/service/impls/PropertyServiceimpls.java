package com.example.demo.service.impls;

import java.util.List;
import org.springframwork.beans.factory.annotation.Autowired;
import org.springframwork.stereotype.Service;

import com.example.demo.entity.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;

@Service
public class PropertyServiceimpls implements PropertyService {

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