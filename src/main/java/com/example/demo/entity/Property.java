// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;


// @Entity
//public class Property{

//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String title;
//     private String address;
//     private String city;
//     private Double price;
//     private Double  areaSqFt;
     
//      public Long getid(){
//         return id;
//      }
//      public void setid(Long id){
//         this.id=id;
//     }

     
//      public String gettitle(){
//         return title;
//      }
//      public void settitle(String title){
//         this.title=title;
//      }

//      public String getaddress(){
//         return address;
//      }
//      public void setaddress(String address){
//         this.address=address;
//      }

//     public String getcity(){
//         return city;
//      }
//      public void setcity(String city){
//         this.city=city;
//      }

//      public Double getprice(){
//         return price;
//      }
//      public void setprice(Double price){
//         this.price=price;
//     }

//      public Double getareaSqFt(){
//         return areaSqFt;
//      }
//      public void setareaSqFt(Double areaSqFt){
//         this.areaSqFt=areaSqFt;
//      }
     
//     public Property(Long id,String title, String address,String city,Double price, Double areaSqFt){
//       this.id=id;
//       this.title=title;
//       this.address=address;
//       this.city=city;
//       this.price=price;
//       this.areaSqFt=areaSqFt;


//    }
//    public Property(){
      
//   }

// }


package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "area_sqft", nullable = false)
    private Double areaSqFt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacilityScore> facilityScores = new ArrayList<>();

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getAreaSqFt() { return areaSqFt; }
    public void setAreaSqFt(Double areaSqFt) { this.areaSqFt = areaSqFt; }

    public List<FacilityScore> getFacilityScores() { return facilityScores; }
    public void setFacilityScores(List<FacilityScore> facilityScores) { this.facilityScores = facilityScores; }
}

