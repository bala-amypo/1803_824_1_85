package com.example.demo.entity;
import java.time.LocalDateTime;
public class RatingLog{
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
     
}