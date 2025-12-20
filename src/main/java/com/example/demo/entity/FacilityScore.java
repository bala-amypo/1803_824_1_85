// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// @Entity
// public class FacilityScore{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private Integer schoolProximity;
//     private Integer hospitalProximity;
//     private Integer transportAccess;
//     private Integer safetyScore;
   
     
//    public Long getId(){
//         return id;
//     }
//    public void setId(Long id){
//         this.id=id;
//      }

//    public Integer setSchoolProximity(){
//         return schoolProximity;
//     }
//    public void getSchoolProximity(Integer schoolProximity){
//         this.schoolProximity=schoolProximity;
//      }

//    public Integer setHospitalProximity(){
//         return hospitalProximity;
//      }

//    public void getHospitalProximity(Integer hospitalProximity){
//         this.hospitalProximity=hospitalProximity;
//      }

//    public Integer setTransportAccess(){
//         return transportAccess;
//      }
//    public void getTransportAccess(Integer transportAccess){
//         this.transportAccess=transportAccess;
//      }

//    public Integer setSafetyScore(){
//         return safetyScore;
//     }
//    public void getSafetyScore(Integer safetyScore){
//         this.safetyScore=safetyScore;
//     }

//    public FacilityScore(Long id,Integer schoolProximity,Integer hospitalProximity,Integer transportAccess,Integer safetyScore){
//       this.id=id;
     
//       this.schoolProximity=schoolProximity;
//       this.hospitalProximity=hospitalProximity;
//       this.transportAccess=transportAccess;
//       this.safetyScore=safetyScore;
//    }

//    public FacilityScore(){
//    }
//}


     
    
     
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class FacilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Column(nullable = false)
    @Min(0) @Max(10)
    private Integer schoolProximity;

    @Column(nullable = false)
    @Min(0) @Max(10)
    private Integer hospitalProximity;

    @Column(nullable = false)
    @Min(0) @Max(10)
    private Integer transportAccess;

    @Column(nullable = false)
    @Min(0) @Max(10)
    private Integer safetyScore;

    // ===== Getters and Setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public Integer getSchoolProximity() { return schoolProximity; }
    public void setSchoolProximity(Integer schoolProximity) { this.schoolProximity = schoolProximity; }

    public Integer getHospitalProximity() { return hospitalProximity; }
    public void setHospitalProximity(Integer hospitalProximity) { this.hospitalProximity = hospitalProximity; }

    public Integer getTransportAccess() { return transportAccess; }
    public void setTransportAccess(Integer transportAccess) { this.transportAccess = transportAccess; }

    public Integer getSafetyScore() { return safetyScore; }
    public void setSafetyScore(Integer safetyScore) { this.safetyScore = safetyScore; }
}



