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


package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import java.util.*;

@Entity
@Table(name = "properties")
public class Property {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String address;
    private String city;
    @Min(0) private Double price;
    @Min(100) private Double areaSqFt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RatingLog> ratingLogs = new ArrayList<>();

    @ManyToMany(mappedBy = "assignedProperties")
    private Set<User> assignedUsers = new HashSet<>();

    public Property() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getAreaSqFt() { return areaSqFt; }
    public void setAreaSqFt(Double areaSqFt) { this.areaSqFt = areaSqFt; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public List<RatingLog> getRatingLogs() { return ratingLogs; }
    public Set<User> getAssignedUsers() { return assignedUsers; }
    public void addRatingLog(RatingLog log) {
        ratingLogs.add(log);
        log.setProperty(this);
    }
}