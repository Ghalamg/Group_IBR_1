package myrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyRental {
   
    //array of users with 4 slots
    static User user[] = new User[4];
    //scanner to read from user
    static Scanner input1=new Scanner(System.in);
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        File users = new File("usersDatabase.txt");//file with users in database
        if (!users.exists()) {
            //check if the file exists.
            System.out.println("the file does not exist ");
            System.exit(0);
        } //End of if
        
        //scanner to read from file
        Scanner input = new Scanner(users);
        //database method call(read 3 users from file and store in users array of objects)
        Database(users,input);
   
        //login choices
        System.out.println("              MYRENTAL              "+"\n enter 1 to log in and 2 to sign up");
        int choice=input1.nextInt();
        
        if(choice==1){
            //if the user chooses to login
            login();
        } else if(choice==2){
            //if the user chooses to suign up, add new user to the 4th empty slot
            user[4]=signUp();
        } //End of if/else
        
        makeRental();
        
        input.close();

    } //End of main method
    
    //read username and password from user and send to search method
    public static void login(){
            User currentUser=new User();
            String username;
            String password;
            System.out.println("enter your username");
            username=input1.next();
            System.out.println("enter your password");
            password=input1.next();
            
            if(searchUser(username,password)==true){
               System.out.println("login succes"); 
               
            } else if(searchUser(username,password)==false){
               System.out.println("wrong password,try again");
               login();
               
            } else{
               System.out.println("user does not exist,try again");
               login();
               
            } //End of if/else if/else
            
    } //End of login method
    
    public static boolean searchUser(String username,String password){
        //search for user in database
        for(int i=0;i<user.length-1;i++){
            
            //Return true if username & password of user are both correct
            if(user[i].getUserName().equals(username) && user[i].getPassword().equals(password)){
                return true;
                
            // Return false if username is correct but the password is wrong
            } else if(!user[i].getPassword().equals(password) && user[i].getUserName().equals(username) ){
                return false;
                
            } //End of if/else if
        } //End of for loop
        return true;
    } //End of searchUser method
    
    public static User signUp(){
        User newUser= User.Signup();
        System.out.println("sign-up succesful ");
        login();//go to login page after sign up
        return newUser;
        
    } //End of signUp method
   
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
            
        } //End of wjile loop
        
        input.close();
    
    } //End of Database method

    public static void makeRental(){
        
    } //End of makeRental method
    
}  //End of class
