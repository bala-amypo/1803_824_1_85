// package com.example.demo.entity;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// @Entity
// public class User{
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     @Column(unique=true)
//     private String email;
//     private String password;
//     private String role;
     
//      public Long getId(){
//         return id;
//      }
//      public void setId(Long id){
//         this.id=id;
//      }
//      public String getName(){
//         return name;
//      }
//      public void setName(String name){
//         this.name=name;
//      }
//      public String getEmail(){
//         return email;
//      }
//      public void setEmail(String email){
//         this.email=email;
//      }
//      public String getPassword(){
//         return password;
//      }
//      public void setPassword(String password){
//         this.password=password;
//      }
//      public String getRole(){
//         return role;
//      }
//      public void setRole(String role){
//         this.role=role;
//      }
//    public User(Long id,String name,String email,String password,String role){
//       this.id=id;
//       this.name=name;
//       this.email=email;
//       this.password=password;
//       this.role=role;
//    }
//    public User(){

//    }

// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.*;
// import java.util.*;

// @Entity
// @Table(name = "users")
// @Getter @Setter @NoArgsConstructor
// public class User {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     @Column(unique = true) private String email;
//     private String password;
//     private String role; 

//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "user_properties",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "property_id"))
//     private Set<Property> assignedProperties = new HashSet<>();
// }


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.*;

// @Entity
// @Table(name = "users")
// public class User {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     @Column(unique = true) private String email;
//     private String password;
//     private String role;

//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "user_props", joinColumns = @JoinColumn(name = "u_id"), inverseJoinColumns = @JoinColumn(name = "p_id"))
//     private Set<Property> assignedProperties = new HashSet<>();

//     public User() {}
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
//     public Set<Property> getAssignedProperties() { return assignedProperties; }
// }



// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.util.*;

// @Entity
// @Table(name = "user")
// public class User {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     @Column(unique = true) private String email;
//     private String password;
//     private String role;

//     @ManyToMany(fetch = FetchType.LAZY)
//     @JoinTable(name = "user_props", 
//                joinColumns = @JoinColumn(name = "u_id"), 
//                inverseJoinColumns = @JoinColumn(name = "p_id"))
//     private Set<Property> assignedProperties = new HashSet<>();

//     public User() {}
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
//     public Set<Property> getAssignedProperties() { return assignedProperties; }
//}


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank(message = "Name is required")
//     @Size(min = 2, max = 100)
//     @Column(nullable = false)
//     private String name;

//     @NotBlank(message = "Email is required")
//     @Email(message = "Invalid email format")
//     @Column(unique = true, nullable = false)
//     private String email;

//     @NotBlank(message = "Password is required")
//     @Size(min = 6)
//     @Column(nullable = false)
//     private String password;

//     @NotBlank(message = "Role is required")
//     @Column(nullable = false)
//     private String role; // ADMIN, ANALYST

//     // Many-to-Many: User can be assigned to multiple Properties
//     @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//     @JoinTable(
//         name = "user_property_assignments",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "property_id")
//     )
//     private Set<Property> assignedProperties = new HashSet<>();

//     // Constructors
//     public User() {
//     }

//     public User(String name, String email, String password, String role) {
//         this.name = name;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }

//     public Set<Property> getAssignedProperties() {
//         return assignedProperties;
//     }

//     public void setAssignedProperties(Set<Property> assignedProperties) {
//         this.assignedProperties = assignedProperties;
//     }
// }



// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @Getter @Setter
// @Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @Column(nullable = false, unique = true)
//     private String email;

//     private String password;

//     private String role;

//     @ManyToMany
//     @JoinTable(
//         name = "user_property",
//         joinColumns = @JoinColumn(name = "user_id"),
//         inverseJoinColumns = @JoinColumn(name = "property_id")
//     )
//     private Set<Property> assignedProperties = new HashSet<>();
// }



package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String role;

    @ManyToMany
    @JoinTable(
        name = "user_property",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "property_id")
    )
    private Set<Property> assignedProperties = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Set<Property> getAssignedProperties() { return assignedProperties; }
    public void setAssignedProperties(Set<Property> assignedProperties) {
        this.assignedProperties = assignedProperties;
    }
}
