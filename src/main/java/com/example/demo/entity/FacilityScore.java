package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class FacilityScore{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Integer schoolProximity;
    private Integer hospitalProximity;
    private Integer transportAccess;
    private Integer safetyScore;
   
     
   public Long getid(){
        return id;
     }
   public void setid(Long id){
        this.id=id;
     }

   public Integer setschoolProximity(){
        return schoolProximity;
     }
   public void getschoolProximity(Integer schoolProximity){
        this.schoolProximity=schoolProximity;
     }

   public Integer sethospitalProximity(){
        return hospitalProximity;
     }

   public void gethospitalProximity(Integer hospitalProximity){
        this.hospitalProximity=hospitalProximity;
     }

   public Integer settransportAccess(){
        return transportAccess;
     }
   public void gettransportAccess(Integer transportAccess){
        this.transportAccess=transportAccess;
     }

   public Integer setsafetyScore(){
        return safetyScore;
     }
   public void getsafetyScore(Integer safetyScore){
        this.safetyScore=safetyScore;
     }

   public FacilityScore(Long id, Integer schoolProximity,Integer hospitalProximity,Integer transportAccess,Integer safetyScore){
      this.id=id;
      
      this.schoolProximity=schoolProximity;
      this.hospitalProximity=hospitalProximity;
      this.transportAccess=transportAccess;
      this.safetyScore=safetyScore;
   }

   public FacilityScore(){
   }
}


     
    
     
