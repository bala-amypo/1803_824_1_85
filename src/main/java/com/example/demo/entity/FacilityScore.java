
package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "facility_scores")
public class FacilityScore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne @JoinColumn(name = "property_id", unique = true)
    private Property property;
    @Min(0) @Max(10) private Integer schoolProximity;
    @Min(0) @Max(10) private Integer hospitalProximity;
    @Min(0) @Max(10) private Integer transportAccess;
    @Min(0) @Max(10) private Integer safetyScore;

    public FacilityScore() {}
    public Long getId() { return id; }
    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }
    public Integer getSchoolProximity() { return schoolProximity; }
    public void setSchoolProximity(Integer s) { this.schoolProximity = s; }
    public Integer getHospitalProximity() { return hospitalProximity; }
    public void setHospitalProximity(Integer h) { this.hospitalProximity = h; }
    public Integer getTransportAccess() { return transportAccess; }
    public void setTransportAccess(Integer t) { this.transportAccess = t; }
    public Integer getSafetyScore() { return safetyScore; }
    public void setSafetyScore(Integer s) { this.safetyScore = s; }
}


