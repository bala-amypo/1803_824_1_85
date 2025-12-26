
// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.PrePersist;
// import java.time.LocalDateTime;

// @Entity
// public class RatingResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "property_id", unique = true)
//     private Property property;

//     private Double finalRating;

//     private String ratingCategory;

//     private LocalDateTime ratedAt;

//     @PrePersist
//     public void prePersist() {
//         this.ratedAt = LocalDateTime.now();
//     }

//     public RatingResult() {}

//     public RatingResult(Property property, Double finalRating, String ratingCategory) {
//         this.property = property;
//         this.finalRating = finalRating;
//         this.ratingCategory = ratingCategory;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }

//     public Double getFinalRating() { return finalRating; }
//     public void setFinalRating(Double finalRating) { this.finalRating = finalRating; }

//     public String getRatingCategory() { return ratingCategory; }
//     public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

//     public LocalDateTime getRatedAt() { return ratedAt; }
//     public void setRatedAt(LocalDateTime ratedAt) { this.ratedAt = ratedAt; }
//}

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "rating_results")
// @Getter @Setter @NoArgsConstructor
// public class RatingResult {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @OneToOne @JoinColumn(name = "property_id")
//     private Property property;
//     private Double finalRating;
//     private String ratingCategory;
//     private LocalDateTime ratedAt;

//     @PrePersist protected void onCreate() { ratedAt = LocalDateTime.now(); }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "ratingresults")
// public class RatingResult {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne
//     @JoinColumn(name = "property_id")
//     private Property property;

//     private Double finalRating;
//     private String ratingCategory;
//     private LocalDateTime ratedAt;

//     @PrePersist
//     protected void onCreate() {
//         ratedAt = LocalDateTime.now();
//     }

//     public RatingResult() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }

//     public Double getFinalRating() { return finalRating; }
//     public void setFinalRating(Double finalRating) { this.finalRating = finalRating; }

//     public String getRatingCategory() { return ratingCategory; }
//     public void setRatingCategory(String ratingCategory) { this.ratingCategory = ratingCategory; }

//     public LocalDateTime getRatedAt() { return ratedAt; }
//     public void setRatedAt(LocalDateTime ratedAt) { this.ratedAt = ratedAt; }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import org.hibernate.annotations.CreationTimestamp;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "rating_results")
// public class RatingResult {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // One-to-One with Property
//     @OneToOne
//     @JoinColumn(name = "property_id", unique = true, nullable = false)
//     private Property property;

//     @NotNull(message = "Final rating is required")
//     @Column(name = "final_rating", nullable = false)
//     private Double finalRating;

//     @NotNull(message = "Rating category is required")
//     @Column(name = "rating_category", nullable = false)
//     private String ratingCategory; // EXCELLENT, GOOD, AVERAGE, POOR

//     @CreationTimestamp
//     @Column(name = "rated_at", nullable = false, updatable = false)
//     private LocalDateTime ratedAt;

//     // Constructors
//     public RatingResult() {
//     }

//     public RatingResult(Property property, Double finalRating, String ratingCategory) {
//         this.property = property;
//         this.finalRating = finalRating;
//         this.ratingCategory = ratingCategory;
//     }

//     // Helper method to determine category based on rating
//     public static String determineCategory(Double rating) {
//         if (rating >= 8.0) {
//             return "EXCELLENT";
//         } else if (rating >= 6.0) {
//             return "GOOD";
//         } else if (rating >= 4.0) {
//             return "AVERAGE";
//         } else {
//             return "POOR";
//         }
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Property getProperty() {
//         return property;
//     }

//     public void setProperty(Property property) {
//         this.property = property;
//     }

//     public Double getFinalRating() {
//         return finalRating;
//     }

//     public void setFinalRating(Double finalRating) {
//         this.finalRating = finalRating;
//     }

//     public String getRatingCategory() {
//         return ratingCategory;
//     }

//     public void setRatingCategory(String ratingCategory) {
//         this.ratingCategory = ratingCategory;
//     }

//     public LocalDateTime getRatedAt() {
//         return ratedAt;
//     }

//     public void setRatedAt(LocalDateTime ratedAt) {
//         this.ratedAt = ratedAt;
//     }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class RatingResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double finalRating;
    private String ratingCategory;

    private LocalDateTime ratedAt = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;
}
