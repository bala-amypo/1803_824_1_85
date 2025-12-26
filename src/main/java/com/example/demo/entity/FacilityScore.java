// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// public class FacilityScore {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private double hospitalProximity;
//     private double schoolProximity;
//     private double transportAccess;
//     private double safetyScore;

//     @OneToOne
//     @JoinColumn(name = "property_id", unique = true)
//     private Property property;

//     public FacilityScore() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public double getHospitalProximity() { return hospitalProximity; }
//     public void setHospitalProximity(double hospitalProximity) { this.hospitalProximity = hospitalProximity; }

//     public double getSchoolProximity() { return schoolProximity; }
//     public void setSchoolProximity(double schoolProximity) { this.schoolProximity = schoolProximity; }

//     public double getTransportAccess() { return transportAccess; }
//     public void setTransportAccess(double transportAccess) { this.transportAccess = transportAccess; }

//     public double getSafetyScore() { return safetyScore; }
//     public void setSafetyScore(double safetyScore) { this.safetyScore = safetyScore; }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }
//}


package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "facility_scores")
@Getter @Setter @NoArgsConstructor
public class FacilityScore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id", unique = true)
    private Property property;

    @Min(0) @Max(10) private Integer schoolProximity;
    @Min(0) @Max(10) private Integer hospitalProximity;
    @Min(0) @Max(10) private Integer transportAccess;
    @Min(0) @Max(10) private Integer safetyScore;
}


// package com.example.demo.entity;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.*;

// @Entity
// @Table(name = "facility_scores")
// public class FacilityScore {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @OneToOne @JoinColumn(name = "property_id", unique = true)
//     private Property property;
//     @Min(0) @Max(10) private Integer schoolProximity;
//     @Min(0) @Max(10) private Integer hospitalProximity;
//     @Min(0) @Max(10) private Integer transportAccess;
//     @Min(0) @Max(10) private Integer safetyScore;

//     public FacilityScore() {}
//     public Long getId() { return id; }
//     public Property getProperty() { return property; }
//     public void setProperty(Property property) { this.property = property; }
//     public Integer getSchoolProximity() { return schoolProximity; }
//     public void setSchoolProximity(Integer s) { this.schoolProximity = s; }
//     public Integer getHospitalProximity() { return hospitalProximity; }
//     public void setHospitalProximity(Integer h) { this.hospitalProximity = h; }
//     public Integer getTransportAccess() { return transportAccess; }
//     public void setTransportAccess(Integer t) { this.transportAccess = t; }
//     public Integer getSafetyScore() { return safetyScore; }
//     public void setSafetyScore(Integer s) { this.safetyScore = s; }
//}


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;

// @Entity
// @Table(name = "facility_scores")
// public class FacilityScore {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // One-to-One with Property (unique constraint on property_id)
//     @OneToOne
//     @JoinColumn(name = "property_id", unique = true, nullable = false)
//     private Property property;

//     @NotNull(message = "School proximity score is required")
//     @Min(value = 0, message = "Score must be between 0 and 10")
//     @Max(value = 10, message = "Score must be between 0 and 10")
//     @Column(name = "school_proximity", nullable = false)
//     private Integer schoolProximity;

//     @NotNull(message = "Hospital proximity score is required")
//     @Min(value = 0, message = "Score must be between 0 and 10")
//     @Max(value = 10, message = "Score must be between 0 and 10")
//     @Column(name = "hospital_proximity", nullable = false)
//     private Integer hospitalProximity;

//     @NotNull(message = "Transport access score is required")
//     @Min(value = 0, message = "Score must be between 0 and 10")
//     @Max(value = 10, message = "Score must be between 0 and 10")
//     @Column(name = "transport_access", nullable = false)
//     private Integer transportAccess;

//     @NotNull(message = "Safety score is required")
//     @Min(value = 0, message = "Score must be between 0 and 10")
//     @Max(value = 10, message = "Score must be between 0 and 10")
//     @Column(name = "safety_score", nullable = false)
//     private Integer safetyScore;

//     // Constructors
//     public FacilityScore() {
//     }

//     public FacilityScore(Property property, Integer schoolProximity, Integer hospitalProximity,
//                          Integer transportAccess, Integer safetyScore) {
//         this.property = property;
//         this.schoolProximity = schoolProximity;
//         this.hospitalProximity = hospitalProximity;
//         this.transportAccess = transportAccess;
//         this.safetyScore = safetyScore;
//     }

//     // Calculate average score
//     public Double calculateAverageScore() {
//         return (schoolProximity + hospitalProximity + transportAccess + safetyScore) / 4.0;
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

//     public Integer getSchoolProximity() {
//         return schoolProximity;
//     }

//     public void setSchoolProximity(Integer schoolProximity) {
//         this.schoolProximity = schoolProximity;
//     }

//     public Integer getHospitalProximity() {
//         return hospitalProximity;
//     }

//     public void setHospitalProximity(Integer hospitalProximity) {
//         this.hospitalProximity = hospitalProximity;
//     }

//     public Integer getTransportAccess() {
//         return transportAccess;
//     }

//     public void setTransportAccess(Integer transportAccess) {
//         this.transportAccess = transportAccess;
//     }

//     public Integer getSafetyScore() {
//         return safetyScore;
//     }

//     public void setSafetyScore(Integer safetyScore) {
//         this.safetyScore = safetyScore;
//     }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Max;
// import jakarta.validation.constraints.Min;

// @Entity
// public class FacilityScore {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Min(0) @Max(10)
//     private int schoolProximity;

//     @Min(0) @Max(10)
//     private int hospitalProximity;

//     @Min(0) @Max(10)
//     private int transportAccess;

//     @Min(0) @Max(10)
//     private int safetyScore;

//     @OneToOne
//     @JoinColumn(name = "property_id", unique = true)
//     private Property property;

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public int getSchoolProximity() { return schoolProximity; }
//     public void setSchoolProximity(int schoolProximity) {
//         this.schoolProximity = schoolProximity;
//     }

//     public int getHospitalProximity() { return hospitalProximity; }
//     public void setHospitalProximity(int hospitalProximity) {
//         this.hospitalProximity = hospitalProximity;
//     }

//     public int getTransportAccess() { return transportAccess; }
//     public void setTransportAccess(int transportAccess) {
//         this.transportAccess = transportAccess;
//     }

//     public int getSafetyScore() { return safetyScore; }
//     public void setSafetyScore(int safetyScore) {
//         this.safetyScore = safetyScore;
//     }

//     public Property getProperty() { return property; }
//     public void setProperty(Property property) {
//         this.property = property;
//     }
// }
