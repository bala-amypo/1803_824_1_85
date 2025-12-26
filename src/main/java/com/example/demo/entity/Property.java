// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.Objects;

// @Entity
// public class Property {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     public Property() {}

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (!(o instanceof Property)) return false;
//         Property p = (Property) o;
//         return Objects.equals(id, p.id);
//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(id);
//     }
//}


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;
// import lombok.*;
// import java.util.*;

// @Entity
// @Table(name = "properties")
// @Getter @Setter @NoArgsConstructor
// public class Property {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//     private String address;
//     private String city;
//     @Min(0) private Double price;
//     @Min(100) private Double areaSqFt;

//     @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<RatingLog> ratingLogs = new ArrayList<>();

//     @ManyToMany(mappedBy = "assignedProperties")
//     private Set<User> assignedUsers = new HashSet<>();

//     public void addRatingLog(RatingLog log) {
//         ratingLogs.add(log);
//         log.setProperty(this);
//     }
// }


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;
// import java.util.*;

// @Entity
// @Table(name = "properties")
// public class Property {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//     private String address;
//     private String city;
//     @Min(0) private Double price;
//     @Min(100) private Double areaSqFt;

//     @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<RatingLog> ratingLogs = new ArrayList<>();

//     @ManyToMany(mappedBy = "assignedProperties")
//     private Set<User> assignedUsers = new HashSet<>();

//     public Property() {}
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }
//     public Double getPrice() { return price; }
//     public void setPrice(Double price) { this.price = price; }
//     public Double getAreaSqFt() { return areaSqFt; }
//     public void setAreaSqFt(Double areaSqFt) { this.areaSqFt = areaSqFt; }
//     public String getCity() { return city; }
//     public void setCity(String city) { this.city = city; }
//     public String getAddress() { return address; }
//     public void setAddress(String address) { this.address = address; }
//     public List<RatingLog> getRatingLogs() { return ratingLogs; }
//     public Set<User> getAssignedUsers() { return assignedUsers; }
//     public void addRatingLog(RatingLog log) {
//         ratingLogs.add(log);
//         log.setProperty(this);
//     }
// }


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;
// import java.util.*;

// @Entity
// @Table(name = "properties")
// public class Property {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//     private String address;
//     private String city;
//     @Min(0) private Double price;
//     @Min(100) private Double areaSqFt;

//     @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//     private List<RatingLog> ratingLogs = new ArrayList<>();

//     @ManyToMany(mappedBy = "assignedProperties")
//     private Set<User> assignedUsers = new HashSet<>();

//     public Property() {}
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }
//     public String getAddress() { return address; }
//     public void setAddress(String address) { this.address = address; }
//     public String getCity() { return city; }
//     public void setCity(String city) { this.city = city; }
//     public Double getPrice() { return price; }
//     public void setPrice(Double price) { this.price = price; }
//     public Double getAreaSqFt() { return areaSqFt; }
//     public void setAreaSqFt(Double areaSqFt) { this.areaSqFt = areaSqFt; }
//     public List<RatingLog> getRatingLogs() { return ratingLogs; }
//     public Set<User> getAssignedUsers() { return assignedUsers; }
    
//     public void addRatingLog(RatingLog log) {
//         ratingLogs.add(log);
//         log.setProperty(this);
//     }
//}


// package com.example.demo.entity;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// @Entity
// @Table(name = "properties")
// public class Property {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank(message = "Title is required")
//     @Column(nullable = false)
//     private String title;

//     @NotBlank(message = "Address is required")
//     @Column(nullable = false)
//     private String address;

//     @NotBlank(message = "City is required")
//     @Column(nullable = false)
//     private String city;

//     @NotNull(message = "Price is required")
//     @Min(value = 0, message = "Price must be positive")
//     @Column(nullable = false)
//     private Double price;

//     @NotNull(message = "Area is required")
//     @Min(value = 100, message = "Area must be at least 100 sq ft")
//     @Column(name = "area_sq_ft", nullable = false)
//     private Double areaSqFt;

//     // One-to-One with FacilityScore
//     @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//     @JsonIgnore
//     private FacilityScore facilityScore;

//     // One-to-One with RatingResult
//     @OneToOne(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//     @JsonIgnore
//     private RatingResult ratingResult;

//     // One-to-Many with RatingLog
//     @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
//     @JsonIgnore
//     private List<RatingLog> ratingLogs = new ArrayList<>();

//     // Many-to-Many: Properties can be assigned to multiple Users
//     @ManyToMany(mappedBy = "assignedProperties", fetch = FetchType.LAZY)
//     @JsonIgnore
//     private Set<User> assignedUsers = new HashSet<>();

//     // Constructors
//     public Property() {
//     }

//     public Property(String title, String address, String city, Double price, Double areaSqFt) {
//         this.title = title;
//         this.address = address;
//         this.city = city;
//         this.price = price;
//         this.areaSqFt = areaSqFt;
//     }

//     // Helper method to add rating log
//     public void addRatingLog(RatingLog log) {
//         ratingLogs.add(log);
//         log.setProperty(this);
//     }

//     // Helper method to remove rating log
//     public void removeRatingLog(RatingLog log) {
//         ratingLogs.remove(log);
//         log.setProperty(null);
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public void setTitle(String title) {
//         this.title = title;
//     }

//     public String getAddress() {
//         return address;
//     }

//     public void setAddress(String address) {
//         this.address = address;
//     }

//     public String getCity() {
//         return city;
//     }

//     public void setCity(String city) {
//         this.city = city;
//     }

//     public Double getPrice() {
//         return price;
//     }

//     public void setPrice(Double price) {
//         this.price = price;
//     }

//     public Double getAreaSqFt() {
//         return areaSqFt;
//     }

//     public void setAreaSqFt(Double areaSqFt) {
//         this.areaSqFt = areaSqFt;
//     }

//     public FacilityScore getFacilityScore() {
//         return facilityScore;
//     }

//     public void setFacilityScore(FacilityScore facilityScore) {
//         this.facilityScore = facilityScore;
//     }

//     public RatingResult getRatingResult() {
//         return ratingResult;
//     }

//     public void setRatingResult(RatingResult ratingResult) {
//         this.ratingResult = ratingResult;
//     }

//     public List<RatingLog> getRatingLogs() {
//         return ratingLogs;
//     }

//     public void setRatingLogs(List<RatingLog> ratingLogs) {
//         this.ratingLogs = ratingLogs;
//     }

//     public Set<User> getAssignedUsers() {
//         return assignedUsers;
//     }

//     public void setAssignedUsers(Set<User> assignedUsers) {
//         this.assignedUsers = assignedUsers;
//     }
// }