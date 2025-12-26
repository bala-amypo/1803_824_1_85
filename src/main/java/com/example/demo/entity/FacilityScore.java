package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class FacilityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double hospitalProximity;
    private double schoolProximity;
    private double transportAccess;
    private double safetyScore;

    @OneToOne
    @JoinColumn(name = "property_id", unique = true)
    private Property property;

    public FacilityScore() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getHospitalProximity() { return hospitalProximity; }
    public void setHospitalProximity(double hospitalProximity) { this.hospitalProximity = hospitalProximity; }

    public double getSchoolProximity() { return schoolProximity; }
    public void setSchoolProximity(double schoolProximity) { this.schoolProximity = schoolProximity; }

    public double getTransportAccess() { return transportAccess; }
    public void setTransportAccess(double transportAccess) { this.transportAccess = transportAccess; }

    public double getSafetyScore() { return safetyScore; }
    public void setSafetyScore(double safetyScore) { this.safetyScore = safetyScore; }

    public Property getProperty() { return property; }
    public void setProperty(Property property) { this.property = property; }
}
