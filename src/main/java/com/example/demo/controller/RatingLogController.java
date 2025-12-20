// package com.example.demo.controller;

// import com.example.demo.entity.RatingLog;
// import com.example.demo.service.RatingLogService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;

// @RestController
//@RequestMapping("/logs")
// public class RatingLogController {

//     public final RatingLogService ratingLogService;

//     public RatingLogController(RatingLogService ratingLogService) {
//         this.ratingLogService = ratingLogService;
//     }

  
//     @PostMapping("/{propertyId}")
//     public RatingLog addLog(@PathVariable Long propertyId, @RequestParam String message) {
//         return ratingLogService.addLog(propertyId, message);
//     }

    
//     @GetMapping("/{propertyId}")
//     public List<RatingLog> getLogs(@PathVariable Long propertyId) {
//         return ratingLogService.getLogsByProperty(propertyId);
//     }
//}


package com.example.demo.controller;

import com.example.demo.entity.RatingLog;
import com.example.demo.service.RatingLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class RatingLogController {

    private final RatingLogService ratingLogService;

    public RatingLogController(RatingLogService ratingLogService) {
        this.ratingLogService = ratingLogService;
    }

    @PostMapping("/{propertyId}")
    public ResponseEntity<RatingLog> addLog(@PathVariable Long propertyId,
                                            @RequestParam String message) {
        RatingLog log = ratingLogService.addLog(propertyId, message);
        return ResponseEntity.status(HttpStatus.CREATED).body(log);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<List<RatingLog>> getLogs(@PathVariable Long propertyId) {
        List<RatingLog> logs = ratingLogService.getLogsByProperty(propertyId);
        return ResponseEntity.ok(logs);
    }
}
