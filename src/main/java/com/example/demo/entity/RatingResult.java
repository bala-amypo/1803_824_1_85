package com.example.demo.entity;
import java.time.LocalDateTime;
public class RatingResult{
    private Long id;
    private Property property;
    private Double finalRating;
    private String ratingCategory;
    private LocalDateTime ratedAt;
    
     
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

      public Double setfinalRating(){
        return finalRating;
     }
     public void getfinalRating(String finalRating){
        this.finalRating=finalRating;
     }

     public String (){
        return message;
     }
     public void setmessage(String message){
        this.message=message;
     }
     
     public LocalDateTime getloggedAt(){
        return loggedAt;
     }
     public void setloggedAt(Double loggedAt){
        this.loggedAt=loggedAt;
     }
     
}