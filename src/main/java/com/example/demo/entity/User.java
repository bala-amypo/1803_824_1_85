package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
@Entity
public class User{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @column(unique=true)
    private String email;
    private String password;
    private String role;
     
     public Long getid(){
        return id;
     }
     public void setid(Long id){
        this.id=id;
     }
     public String getname(){
        return name;
     }
     public void setname(String name){
        this.name=name;
     }
     public String getemail(){
        return email;
     }
     public void setemail(String email){
        this.email=email;
     }
     public String getpassword(){
        return password;
     }
     public void setpassword(String password){
        this.password=password;
     }
     public String getrole(){
        return role;
     }
     public void setrole(String role){
        this.role=role;
     }
   public User(Long id,String name,String email,String password,String role){
      this.id=id;
      this.name=name;
      this.email=email;
      this.password=password;
      this.role=role;
   }
   public User(){

   }

}
