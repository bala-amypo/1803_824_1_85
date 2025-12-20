
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.FacilityScore;

public interface FacilityScoreRepository extends JpaRepository<FacilityScore,Long> {
}