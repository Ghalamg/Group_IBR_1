package myrental;

import static myrental.MyRental.input1;


public class User {
    
 private String Fname,Lname,UserName,password,Email;
   
   public User(){
       
   }
   
   public User(String Fname,String Lname,String UserName,String password,String Email){
       Fname=this.Fname;
       Lname=this.Lname;
       UserName=this.UserName;
       password=this.password;
       Email=this.Email;
  
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

    @Override
    public String toString() {
        return  Fname + " "+Lname +" "+  UserName +" "+password  + " "+ Email ;
    }
   
   
    
} //End of class
