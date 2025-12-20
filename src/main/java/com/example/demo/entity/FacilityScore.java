// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManytoOne;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;

// @Entity
// public class FacilityScore{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @ManytoOne
//     private Property property;
//     @Min(value=0)
//     @Max(value=10)
//     private Integer schoolProximity;
//     @Min(value=0)
//     @Max(value=10)
//     private Integer hospitalProximity;
//     @Min(value=0)
//     @Max(value=10)
//     private Integer transportAccess;
//     @Min(value=0)
//     @Max(value=10)
//     private Integer safetyScore;
   
     
//    public Long getId(){
//         return id;
//     }
//    public void setId(Long id){
//         this.id=id;
//      }

//      public Property setProperty(){
//         return safetyScore;
//      }
//    public void getProperty(Property property){
//         this.safetyScore=safetyScore;
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
//      }

//    public FacilityScore(Long id,Property property, Integer schoolProximity,Integer hospitalProximity,Integer transportAccess,Integer safetyScore){
//       this.id=id;
//       this.property=property;
//       this.schoolProximity=schoolProximity;
//       this.hospitalProximity=hospitalProximity;
//       this.transportAccess=transportAccess;
//       this.safetyScore=safetyScore;
//    }

//    public FacilityScore(){
//    }
//}


     
    
     


