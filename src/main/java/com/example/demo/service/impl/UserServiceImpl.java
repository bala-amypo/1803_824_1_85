// package com.example.demo.service.impls;

// import java.lang.String;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// @Service
// public class UserServiceimpls implements UserService {

//     @Autowired
//     public UserRepository repo;

//     @Override
//     public User register(User user) {
//         return repo.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return repo.findByEmail(email);
//     }
//}



// package com.example.demo.service.impl;

// import com.example.demo.entity.User;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {
//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public UserServiceImpl(UserRepository ur, PasswordEncoder pe) {
//         this.userRepository = ur; this.passwordEncoder = pe;
//     }

//     @Override
//     public User registerUser(User user) {
//         if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//             throw new BadRequestException("Email already in use");
//         }
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         if (user.getRole() == null) user.setRole("ANALYST");
//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }
// }