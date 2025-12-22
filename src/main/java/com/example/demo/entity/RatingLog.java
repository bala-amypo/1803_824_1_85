

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_log")
public class RatingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;

    // One-to-One relationship with Property
    @OneToOne(optional = false)  // Must have a property
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "logged_at", nullable = false)
    private LocalDateTime loggedAt;

    // Default constructor
    public RatingLog() {}

    // Constructor without ID (ID is auto-generated)
    public RatingLog(Property property, String message) {
        this.property = property;
        this.message = message;
    }

    // Auto-set loggedAt before insert
    @PrePersist
    protected void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getLoggedAt() { return loggedAt; }
    public void setLoggedAt(LocalDateTime loggedAt) { this.loggedAt = loggedAt; }
}
