

// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Column;
// import jakarta.persistence.PrePersist;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "rating_log")
// public class RatingLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "log_id")
//     private Long id;

    
//     @OneToOne(optional = false) 
//     @JoinColumn(name = "property_id", nullable = false)
//     private Property property;

//     @Column(name = "message", nullable = false)
//     private String message;

//     @Column(name = "logged_at", nullable = false)
//     private LocalDateTime loggedAt;

//     public RatingLog() {}

    
//     public RatingLog(Property property, String message) {
//         this.property = property;
//         this.message = message;
//     }

   
//     @PrePersist
//     protected void onCreate() {
//         this.loggedAt = LocalDateTime.now();
//     }

   
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }

//     public String getMessage() { return message; }
//     public void setMessage(String message) { this.message = message; }

//     public LocalDateTime getLoggedAt() { return loggedAt; }
//     public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
//}




// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "rating_logs")
// public class RatingLog {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "property_id")
//     private Property property;

//     private String message;
//     private LocalDateTime loggedAt;

//     @PrePersist
//     protected void onCreate() {
//         loggedAt = LocalDateTime.now();
//     }

//     public RatingLog() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }

//     public String getMessage() { return message; }
//     public void setMessage(String message) { this.message = message; }

//     public LocalDateTime getLoggedAt() { return loggedAt; }
//     public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "rating_logs")
public class RatingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many-to-One with Property
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Column(nullable = false, length = 1000)
    private String message;

    @CreationTimestamp
    @Column(name = "logged_at", nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    // Constructors
    public RatingLog() {
    }

    public RatingLog(Property property, String message) {
        this.property = property;
        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public void setLoggedAt(LocalDateTime loggedAt) {
        this.loggedAt = loggedAt;
    }
}