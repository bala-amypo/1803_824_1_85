// package com.example.demo.controller;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.Property;
// import com.example.demo.service.PropertyService;

// @RestController
// @RequestMapping("/properties")

// public class PropertyController {

//     @Autowired
//     private PropertyService service;

//     @PostMapping
//     public Property addProperty(@RequestBody Property property) {
//         return service.addProperty(property);
//     }

//     @GetMapping
//     public List<Property> getAll() {
//         return service.getAllProperties();
//     }
// }

package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    
    @PostMapping
    public Property createProperty(@RequestBody Property property) {
        return service.createProperty(property);
    }

    
    @GetMapping
    public List<Property> getAllProperties() {
        return service.getAllProperties();
    }

    
    @GetMapping("/{id}")
    public Property getPropertyById(@PathVariable Long id) {
        return service.getPropertyById(id);
    }

    
    @PutMapping("/{id}")
    public Property updateProperty(@PathVariable Long id, @RequestBody Property property) {
        return service.updateProperty(id, property);
    }

    
    @DeleteMapping("/{id}")
    public String deleteProperty(@PathVariable Long id) {
        service.deleteProperty(id);
        return "Property deleted successfully";
    }
}

