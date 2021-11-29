/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrental;

import static myrental.MyRental.input1;
import static myrental.MyRental.user;

/**
 *
 * @author danii
 */
//a class for all users (costumer,manager,service provider)
public class User {
    //user information
 private String Fname,Lname,UserName,password,Email;
   
   public User(){
       
   }
   //constructor
   public User(String Fname,String Lname,String UserName,String password,String Email){
       Fname=this.Fname;
       Lname=this.Lname;
       UserName=this.UserName;
       password=this.password;
       Email=this.Email;
  
   }

   //method to read new users information creat a new user object and return it to main.
   public static User Signup(){
        String Fname,Lname,Username,password,Email;
        System.out.println("enter your first and last name");
        Fname=input1.next();
        Lname=input1.next();
        System.out.println("enter username ");
        Username=input1.next();
        System.out.println("enter password");
        password=input1.next();
        System.out.println("enter email");
        Email=input1.next();
         
        User newUser=new User();
        return newUser;
   }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return Email;
    }
   
   
    
}
