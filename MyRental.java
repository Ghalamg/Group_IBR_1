/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
                                                                                
/**
 *
 * @author danii
 */
public class MyRental {
 static User user[] = new User[4];//array of users with 4 slots
 static Scanner input1=new Scanner(System.in);//scanner to read from user
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        File users = new File("usersDatabase.txt");//file with users in database
        if (!users.exists()) {
            //check if the files exist.
            System.out.println("the file does not exist ");
            System.exit(0);
        }
           Scanner input = new Scanner(users);//scanner to read from file
         Database(users,input);//database method call(read 3 users from file and store in users aray of objects)
         
         //log in choices
         System.out.println("              MYRENTAL              "+"\n enter 1 to log in and 2 to sign up");
        int choice=input1.nextInt();
        if(choice==1){
            //if the user choose to login
        login();
        }
          else if(choice==2){
                  user[4]=signUp();  
                  //add new user to the 4th empty slot
                }
        
       
        input.close();
       
        
        // TODO code application logic here
    }
    
    public static void login(){//read username and password from user and send to search method
            User currentUser=new User();
            String username;
            String password;
            System.out.println("enter your username");
            username=input1.next();
            System.out.println("enter your password");
            password=input1.next();
           if(searchUser(username,password)==1){
               System.out.println("login succes"); 
           }
           else if(searchUser(username,password)==2){
               System.out.println("wrong password,try again");
               login();
        }
           else{
               System.out.println("user does not exist,try again");
               login();
               
           }
        
    }
    public static int searchUser(String username,String password){
        //search for user in database and return 1 if found and 2 if password wrong and o if not exist
         for(int i=0;i<user.length;i++){
            if(user[i].getUserName()==username&&user[i].getPassword()==password){
                return 1;
            }
            else if(user[i].getUserName()==username&&user[i].getPassword()!=password){
                return 2;
                
            }
           
           
        }
        return 0;
    }   
    public static User signUp(){//
       User newUser= User.Signup();
        System.out.println("sign-up succesful ");
        login();//go to login page after signup
       return newUser;
        
    }
   
    public static void Database(File users, Scanner input) {
        //read 3 users information from file and store in users array of object
      
        int i=0;
        while (input.hasNext()) {
            user[i]=new User();
            user[i].setFname(input.next());
            user[i].setLname(input.next());
            user[i].setUserName(input.next());
            user[i].setPassword(input.next());
            user[i].setEmail(input.next());

            i++;

        }
        input.close();
    
    }

}

