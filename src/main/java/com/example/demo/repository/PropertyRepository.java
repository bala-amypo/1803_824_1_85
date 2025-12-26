
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.Property;

// public interface PropertyRepository extends JpaRepository<Property, Long> {
//}


package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import com.example.demo.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("SELECT p FROM Property p WHERE p.city = :city")
    List<Property> findByCityHql(String city);

    List<Property> findByCity(String city);
}
