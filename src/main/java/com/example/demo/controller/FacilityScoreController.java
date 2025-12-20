// // package com.example.demo.controller;

// // import com.example.demo.entity.FacilityScore;
// // import com.example.demo.service.FacilityScoreService;
// // import jakarta.validation.Valid;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PathVariable;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;
// // import java.util.List;

// // @RestController
// //@RequestMapping("/scores")
// // public class FacilityScoreController {

// //     private final FacilityScoreService facilityScoreService;

// //     public FacilityScoreController(FacilityScoreService facilityScoreService) {
// //         this.facilityScoreService = facilityScoreService;
// //     }

    
// //     @PostMapping("/{propertyId}")
// //     public FacilityScore addScore(@PathVariable Long propertyId,
// //                                   @Valid @RequestBody FacilityScore score) {
// //         return facilityScoreService.addScore(propertyId, score);
// //    }

  
// //     @GetMapping("/{propertyId}")
// //     public FacilityScore getScore(@PathVariable Long propertyId) {
// //         return facilityScoreService.getScoreByProperty(propertyId);
// //     }

    
// //     @GetMapping("/all/{propertyId}")
// //     public List<FacilityScore> getAllScores(@PathVariable Long propertyId) {
// //         return facilityScoreService.getAllScoresByProperty(propertyId);
// //     }
// //}


// package com.example.demo.controller;

// import com.example.demo.entity.FacilityScore;
// import com.example.demo.service.FacilityScoreService;
// import jakarta.validation.Valid;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;

// @RestController
// @RequestMapping("/scores")
// public class FacilityScoreController {

//     private final FacilityScoreService facilityScoreService;

//     public FacilityScoreController(FacilityScoreService facilityScoreService) {
//         this.facilityScoreService = facilityScoreService;
//     }

//     @PostMapping("/{propertyId}")
//     public FacilityScore addScore(@PathVariable Long propertyId,
//                                   @Valid @RequestBody FacilityScore score) {
//         return facilityScoreService.addScore(propertyId, score);
//     }

//     @GetMapping("/{propertyId}")
//     public FacilityScore getScore(@PathVariable Long propertyId) {
//         return facilityScoreService.getScoreByProperty(propertyId);
//     }

//     @GetMapping("/all/{propertyId}")
//     public List<FacilityScore> getAllScores(@PathVariable Long propertyId) {
//         return facilityScoreService.getAllScoresByProperty(propertyId);
//     }
// }


package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.FacilityScore;
import com.example.demo.service.FacilityScoreService;

import java.util.List;

@RestController
@RequestMapping("/facility-scores")
public class FacilityScoreController {

    @Autowired
    private FacilityScoreService service;

    @PostMapping
    public FacilityScore createScore(@RequestBody FacilityScore score) {
        return service.createFacilityScore(score);
    }

    @GetMapping
    public List<FacilityScore> getAllScores() {
        return service.getAllScores();
    }

    @GetMapping("/{id}")
    public FacilityScore getScoreById(@PathVariable Long id) {
        return service.getScoreById(id);
    }

    @GetMapping("/property/{propertyId}")
    public List<FacilityScore> getScoresByProperty(@PathVariable Long propertyId) {
        return service.getScoresByPropertyId(propertyId);
    }

    @DeleteMapping("/{id}")
    public String deleteScore(@PathVariable Long id) {
        service.deleteScore(id);
        return "Deleted successfully";
    }
}
