// package com.example.demo.repository;

// import com.example.demo.entity.RatingLog;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface RatingLogRepository extends JpaRepository<RatingLog, Long> {

//     List<RatingLog> findAllByPropertyId(Long propertyId);
//}

package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

public interface RatingLogRepository extends JpaRepository<RatingLog, Long> {
    List<RatingLog> findByProperty(Property property);
}
