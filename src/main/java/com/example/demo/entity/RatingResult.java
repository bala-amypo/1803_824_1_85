// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "rating_result")
// public class RatingResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne(optional = false)
//     @JoinColumn(name = "property_id", nullable = false, unique = true)
//     private Property property;

//     @Column(nullable = false)
//     private Double finalRating;

//     @Column(nullable = false)
//     private String ratingCategory;

//     @Column(nullable = false)
//     private LocalDateTime calculatedAt;

//     public RatingResult() {}

//     public RatingResult(Property property, Double finalRating, String ratingCategory) {
//         this.property = property;
//         this.finalRating = finalRating;
//         this.ratingCategory = ratingCategory;
//     }

//     @PrePersist
//     public void onCreate() {
//         this.calculatedAt = LocalDateTime.now();
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }

//     public Double getFinalRating() { return finalRating; }
//     public void setFinalRating(Double finalRating) { this.finalRating = finalRating; }

//     public String getRatingCategory() { return ratingCategory; }
//     public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

//     public LocalDateTime getCalculatedAt() { return calculatedAt; }
//     public void setCalculatedAt(LocalDateTime calculatedAt) { this.calculatedAt = calculatedAt; }
//}


package com.example.demo.entity;

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
    @JoinColumn(name = "property_id", unique = true)
    private Property property;

    private Double finalRating;

    private String ratingCategory;

    private LocalDateTime ratedAt;

    @PrePersist
    public void prePersist() {
        this.ratedAt = LocalDateTime.now();
    }

    public RatingResult() {}

    public RatingResult(Property property, Double finalRating, String ratingCategory) {
        this.property = property;
        this.finalRating = finalRating;
        this.ratingCategory = ratingCategory;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public Double getFinalRating() { return finalRating; }
    public void setFinalRating(Double finalRating) { this.finalRating = finalRating; }

    public String getRatingCategory() { return ratingCategory; }
    public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

    public LocalDateTime getRatedAt() { return ratedAt; }
    public void setRatedAt(LocalDateTime ratedAt) { this.ratedAt = ratedAt; }
}
