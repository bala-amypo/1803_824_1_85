
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.Property;

// public interface PropertyRepository extends JpaRepository<Property, Long> {
//}


// package com.example.demo.repository;
// import com.example.demo.entity.Property;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import java.util.List;

// public interface PropertyRepository extends JpaRepository<Property, Long> {
//     @Query("SELECT p FROM Property p WHERE p.city = :city")
//     List<Property> findByCityHql(@Param("city") String city);
//     List<Property> findByCity(String city);
// }

package com.example.demo.repository;

import com.example.demo.entity.Property;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    @Query("select p from Property p where p.city = :city")
    List<Property> findByCityHql(String city);

    List<Property> findByCity(String city);
}
