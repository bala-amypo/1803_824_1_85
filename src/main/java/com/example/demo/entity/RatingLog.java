package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class RatingLog{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Property property;
    private String message;
    private LocalDateTime loggedAt;
    
     
     public Long getid(){
        return id;
     }
     public void setid(Long id){
        this.id=id;
     }
     public Property setproperty(){
        return property;
     }
     public void getproperty(Property property){
        this.property=property;
     }
     public String getmessage(){
        return message;
     }
     public void setmessage(String message){
        this.message=message;
     }
     
     public LocalDateTime getloggedAt(){
        return loggedAt;
     }
     public void setloggedAt(LocalDateTime loggedAt){
        this.loggedAt=loggedAt;
     }

   public RatingLog(Long id,Property property,,String message,LocalDateTime loggedAt){
      this.id=id;
      this.property=property;
      this.message=message;
      this.loggedAt=loggedAt;
   }
   public Ratinglog(){
      
   }
     
}