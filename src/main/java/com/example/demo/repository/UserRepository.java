
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.User;

// public interface UserRepository extends JpaRepository<User,Long> {
//     User findByEmail(String email);
//}

// package com.example.demo.repository;
// import com.example.demo.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByEmail(String email);
//}


package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Find user by email (used for authentication)
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Check if email already exists
     */
    boolean existsByEmail(String email);
}


// package com.example.demo.repository;

// import com.example.demo.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByEmail(String email);
// }



// package com.example.demo.repository;

// import com.example.demo.entity.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByEmail(String email);
// }

