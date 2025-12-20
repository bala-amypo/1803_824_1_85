package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.RatingResult;

public interface RatingResultRepository extends JpaRepository<RatingResult, Long> {
    boolean existsByPropertyId(Long propertyId);
}
