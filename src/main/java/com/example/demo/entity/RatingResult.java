// package com.example.demo.entity;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import java.time.LocalDateTime;

// @Entity
// public class RatingResult{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private Double finalRating;
//     private String ratingCategory;
//     private LocalDateTime ratedAt;
    
     
//      public Long getid(){
//         return id;
//      }
//      public void setid(Long id){
//         this.id=id;
//      }
   
//       public Double getfinalRating(){
//         return finalRating;
//      }
//      public void setfinalRating(Double finalRating){
//         this.finalRating=finalRating;
//      }

//      public String getratingCategory (){
//         return ratingCategory;
//      }
//      public void setratingCategory(String ratingCategory){
//         this.ratingCategory=ratingCategory;
//      }
     
//      public LocalDateTime getratedAt(){
//         return ratedAt;
//      }
//      public void setratedAt(LocalDateTime ratedAt){
//         this.ratedAt=ratedAt;
//      }
     
//     public RatingResult(Long id,Double finalRating,String ratingCategory,LocalDateTime ratedAt){
//       this.id=id;
//       this.finalRating=finalRating;
//       this.ratingCategory=ratingCategory;
//       this.ratedAt=ratedAt;
//    }
//    public RatingResult(){
      
//    }
     
//}



package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false, unique = true)
    private Property property;

    @Column(nullable = false)
    private Double finalRating;

    @Column(nullable = false)
    private String ratingCategory;

    @Column(nullable = false)
    private LocalDateTime calculatedAt;

   
    public RatingResult() {
    }

   
    public RatingResult(Long id,Property property, Double finalRating, String ratingCategory) {
        this.id=id;
        this.property = property;
        this.finalRating = finalRating;
        this.ratingCategory = ratingCategory;
    }

    @PrePersist
    public void onCreate() {
        this.calculatedAt = LocalDateTime.now();
    }

    

    public Long getId() {
        return id;
    }

    public Property getProperty() {
        return property;
    }

    public Double getFinalRating() {
        return finalRating;
    }

    public String getRatingCategory() {
        return ratingCategory;
    }

    public LocalDateTime getCalculatedAt() {
        return calculatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setFinalRating(Double finalRating) {
        this.finalRating = finalRating;
    }

    public void setRatingCategory(String ratingCategory) {
        this.ratingCategory = ratingCategory;
    }

    public void setCalculatedAt(LocalDateTime calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
