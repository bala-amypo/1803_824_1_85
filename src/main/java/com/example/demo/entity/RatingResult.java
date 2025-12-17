package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class RatingResult{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
     public Property getproperty(){
        return property;
     }
     public void setproperty(Property property){
        this.property=property;
     }

      public Double getfinalRating(){
        return finalRating;
     }
     public void setfinalRating(Double finalRating){
        this.finalRating=finalRating;
     }

     public String getratingCategory (){
        return ratingCategory;
     }
     public void setratingCategory(String ratingCategory){
        this.ratingCategory=ratingCategory;
     }
     
     public LocalDateTime getratedAt(){
        return ratedAt;
     }
     public void setratedAt(LocalDateTime ratedAt){
        this.ratedAt=ratedAt;
     }
     
    public RatingResult(Long id,Property property,Double finalRating,String ratingCategory,LocalDateTime ratedAt){
      this.id=id;
      this.property=property;
      this.finalRating=finalRating;
      this.ratingCategory=ratingCategory;
      this.ratedAt=ratedAt;
   }
   public RatingResult(){
      
   }
     
}