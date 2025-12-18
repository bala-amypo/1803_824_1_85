// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;

// @Entity
// public class Property{

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
//      }
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
//      public String getcity(){
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
//      }
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
      
//    }

// }