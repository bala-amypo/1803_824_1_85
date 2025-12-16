package com.example.demo.entity;

public class FacilityScore{
    private Long id;
    private Property property;
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
     
     public Property getproperty(){
        return property;
     }

     public void setproperty(Property property){
        this.property=property;

     } public Integer getschoolProximity(){
        return schoolProximity;
     }

     public void setschoolProximity(Integer schoolProximity){
        this.schoolProximity=schoolProximity;
     }
      public Integer gethospitalProximity(){
        return hospitalProximity;
     }

     public void sethospitalProximity(Integer schoolProximity){
        this.schoolProximity=schoolProximity;
     }

     
    
     
