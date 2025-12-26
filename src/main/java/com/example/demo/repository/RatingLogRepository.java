// package com.example.demo.repository;

// import com.example.demo.entity.RatingLog;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface RatingLogRepository extends JpaRepository<RatingLog, Long> {

//     List<RatingLog> findAllByPropertyId(Long propertyId);
// }


// package com.example.demo.repository;
// import com.example.demo.entity.*;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface RatingLogRepository extends JpaRepository<RatingLog, Long> {
//     List<RatingLog> findByProperty(Property property);
//}

package com.example.demo.repository;

import com.example.demo.entity.Property;
import com.example.demo.entity.RatingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RatingLogRepository extends JpaRepository<RatingLog, Long> {
    
    /**
     * Find all logs for a specific property
     */
    List<RatingLog> findByProperty(Property property);
    
    /**
     * Find logs by property ID
     */
    @Query("SELECT l FROM RatingLog l WHERE l.property.id = :propertyId")
    List<RatingLog> findByPropertyId(@Param("propertyId") Long propertyId);
    
    /**
     * Find logs containing specific message keyword
     */
    @Query("SELECT l FROM RatingLog l WHERE l.message LIKE %:keyword%")
    List<RatingLog> findByMessageContaining(@Param("keyword") String keyword);
    
    /**
     * Find logs created after a specific date
     */
    List<RatingLog> findByLoggedAtAfter(LocalDateTime date);
    
    /**
     * Count logs for a property
     */
    @Query("SELECT COUNT(l) FROM RatingLog l WHERE l.property.id = :propertyId")
    Long countByPropertyId(@Param("propertyId") Long propertyId);
}