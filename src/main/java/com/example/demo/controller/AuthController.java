package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     public UserService service;

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return service.register(user);
//     }

//     @PostMapping("/login")
//     public User login(@RequestBody User user) {
//         return service.findByEmail(user.getemail());
//     }

    
// }


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // Ensure the user has valid data before saving
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
        }

        User savedUser = service.register(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); 
    }

    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User existingUser = service.findByEmail(user.getEmail());
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>(existingUser, HttpStatus.OK); 
}

}
