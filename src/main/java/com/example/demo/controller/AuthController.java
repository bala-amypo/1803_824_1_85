// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;



// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private UserService service;

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return service.register(user);
//     }

//     @PostMapping("/login")
//     public User findByEmail(@RequestBody User user) {
//         return service.findByEmail(user.getEmail());
//     }
//}



// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.entity.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.*;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {
//     private final AuthenticationManager authenticationManager;
//     private final JwtTokenProvider tokenProvider;
//     private final UserService userService;

//     public AuthController(AuthenticationManager am, JwtTokenProvider tp, UserService us) {
//         this.authenticationManager = am; this.tokenProvider = tp; this.userService = us;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
//         User user = new User();
//         user.setName(req.getName());
//         user.setEmail(req.getEmail());
//         user.setPassword(req.getPassword());
//         user.setRole(req.getRole());
//         User savedUser = userService.registerUser(user);

//         Authentication auth = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
//         String token = tokenProvider.generateToken(auth, savedUser);
//         return new ResponseEntity<>(new AuthResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole()), HttpStatus.CREATED);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest req) {
//         Authentication auth = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
//         User user = userService.findByEmail(req.getEmail());
//         String token = tokenProvider.generateToken(auth, user);
//         return ResponseEntity.ok(new AuthResponse(token, user.getId(), user.getEmail(), user.getRole()));
//     }
// }


package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    /**
     * Register a new user
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        // Check if email already exists
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        // Create new user
        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());

        User savedUser = userRepository.save(user);

        // Authenticate and generate token
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerRequest.getEmail(),
                        registerRequest.getPassword()
                )
        );

        String token = tokenProvider.generateToken(authentication, savedUser);

        AuthResponse response = new AuthResponse(token, savedUser.getId(), savedUser.getEmail(), savedUser.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Login user
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = tokenProvider.generateToken(authentication, user);

        AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }
}

