package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManytoOne;

@Entity
public class FacilityScore{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManytoOne
    private Property property;
    private Integer schoolProximity;
    private Integer hospitalProximity;
    private Integer transportAccess;
    private Integer safetyScore;
   
     
   public Long getId(){
        return id;
     }
   public void setId(Long id){
        this.id=id;
     }

   public Integer setSchoolProximity(){
        return schoolProximity;
     }
   public void getSchoolProximity(Integer schoolProximity){
        this.schoolProximity=schoolProximity;
     }

   public Integer setHospitalProximity(){
        return hospitalProximity;
     }

   public void getHospitalProximity(Integer hospitalProximity){
        this.hospitalProximity=hospitalProximity;
     }

   public Integer setTransportAccess(){
        return transportAccess;
     }
   public void getTransportAccess(Integer transportAccess){
        this.transportAccess=transportAccess;
     }

   public Integer setSafetyScore(){
        return safetyScore;
     }
   public void getSafetyScore(Integer safetyScore){
        this.safetyScore=safetyScore;
     }

   public FacilityScore(Long id,Pr Integer schoolProximity,Integer hospitalProximity,Integer transportAccess,Integer safetyScore){
      this.id=id;
      this.property=property;
      this.schoolProximity=schoolProximity;
      this.hospitalProximity=hospitalProximity;
      this.transportAccess=transportAccess;
      this.safetyScore=safetyScore;
   }

   public FacilityScore(){
   }
}


     
    
     
