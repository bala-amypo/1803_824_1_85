// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.RatingResult;
// import com.example.demo.entity.Property;

// @Repository
// public interface RatingResultRepository extends JpaRepository<RatingResult, Long> {
//     RatingResult findByProperty(Property property);
//}

// package com.example.demo.repository;
// import com.example.demo.entity.*;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface RatingResultRepository extends JpaRepository<RatingResult, Long> {
//     Optional<RatingResult> findByProperty(Property property);
// }