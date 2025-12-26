package com.example.demo.repository;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingResult;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RatingResultRepository extends JpaRepository<RatingResult, Long> {
    // Change the return type from RatingResult to Optional<RatingResult>
    Optional<RatingResult> findByProperty(Property property);
}