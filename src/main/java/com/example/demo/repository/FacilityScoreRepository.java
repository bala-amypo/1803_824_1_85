// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.FacilityScore;
// import com.example.demo.entity.Property;

// import java.util.Optional;
// import java.util.List;

// @Repository
// public interface FacilityScoreRepository extends JpaRepository<FacilityScore, Long> {

//     Optional<FacilityScore> findByProperty(Property property);

//     List<FacilityScore> findAllByProperty(Property property);

//     Optional<FacilityScore> findByProperty_Id(Long propertyId);

//     List<FacilityScore> findAllByProperty_Id(Long propertyId);
//}


// package com.example.demo.repository;
// import com.example.demo.entity.*;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface FacilityScoreRepository extends JpaRepository<FacilityScore, Long> {
//     Optional<FacilityScore> findByProperty(Property property);
// }

package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface FacilityScoreRepository extends JpaRepository<FacilityScore, Long> {
    Optional<FacilityScore> findByProperty(Property property);
}

