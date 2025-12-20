package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;

import java.util.Optional;
import java.util.List;

@Repository
public interface FacilityScoreRepository extends JpaRepository<FacilityScore, Long> {

    Optional<FacilityScore> findByProperty(Property property);

    List<FacilityScore> findAllByProperty(Property property);

    // Spring Data JPA way: query by property ID directly
    Optional<FacilityScore> findByProperty_Id(Long propertyId);

    List<FacilityScore> findAllByProperty_Id(Long propertyId);
}
