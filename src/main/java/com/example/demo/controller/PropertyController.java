package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @PostMapping
    public Property addProperty(@RequestBody Property property) {
        return service.addProperty(property);
    }

    @GetMapping
    public List<Property> getAll() {
        return service.getAllProperties();
    }
}