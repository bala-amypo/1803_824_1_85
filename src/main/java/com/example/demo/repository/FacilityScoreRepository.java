package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.FacilityScore;
import com.example.demo.entity.Property;

import java.util.Optional;
import java.util.List;
import java.lang.Long;

@Repository
public interface FacilityScoreRepository extends JpaRepository<FacilityScore, Long> {

    // Find a single FacilityScore by Property
    Optional<FacilityScore> findByProperty(Property property);

    // Convenience method to find by Property id
    default Optional<FacilityScore> findByPropertyId(Long propertyId) {
        return findByProperty(new Property(propertyId));
    }

    // If you want all scores for a property
    List<FacilityScore> findAllByProperty(Property property);
}
