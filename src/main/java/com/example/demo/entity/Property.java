package com.example.demo.entity;

public class Property{
    private Long id;
    private String title;
    private String address;
    private String city;
    private Double price;
    private Double  areaSqFt;
     
     public Long getid(){
        return id;
     }
     public void setid(Long id){
        this.id=id;
     }
     public String gettitle(){
        return title;
     }
     public void settitle(String title){
        this.title=title;
     }
     public String getaddress(){
        return address;
     }
     public void setaddress(String address){
        this.addresss=address;
     }
     public String getcity(){
        return city;
     }
     public void setcity(String city){
        this.city=city;
     }
     public Double getprice(){
        return price;
     }
     public void setprice(Double price){
        this.price=price;
     }
     public Double getareaSqFt(){
        return price;
     }
     public void setareaSqFt(Double areaSqFt){
        this.areaSqFt=areaSqFt;
     }

}