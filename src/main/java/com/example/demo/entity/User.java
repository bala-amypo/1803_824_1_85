package com.example.demo.entity;

public class User{

    private Long id;
    private String name;
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
     public void setname(){
        this.name=name;
     }
     public String getemail(){
        return email;
     }
     public void setemail(){
        this.email=email;
     }
     public String getpassword(){
        return password;
     }
     public void setpassword(){
        this.password=password;
     }
     public String getrole(){
        return role;
     }
     public void setrole(){
        this.role=role;
     }

}
}