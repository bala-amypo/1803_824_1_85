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

     public void setproperty()