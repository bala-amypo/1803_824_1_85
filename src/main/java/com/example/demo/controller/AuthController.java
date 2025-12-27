


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

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository userRepo, PasswordEncoder encoder,
                          AuthenticationManager authManager, JwtTokenProvider jwt) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setRole(req.getRole());
        u.setPassword(encoder.encode(req.getPassword()));
        userRepo.save(u);

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new AuthResponse(jwt.generateToken(auth, u)));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        User user = userRepo.findByEmail(req.getEmail()).orElseThrow();
        return ResponseEntity.ok(new AuthResponse(jwt.generateToken(auth, user)));
    }
}
