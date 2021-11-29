/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danii
 */
public class MyRental {

    static User user[] = new User[4];//array of users with 4 slots
    static Scanner input1 = new Scanner(System.in);//scanner to read from user
    static Car car[] = new Car[3];

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
        Database(users, input);//database method call(read 3 users from file and store in users aray of objects)

        //-------------------------------------------
        //database for cars
        File cars = new File("carsDatabase.txt");//file with users in database
        if (!cars.exists()) {
            //check if the files exist.
            System.out.println("the file does not exist ");
            System.exit(0);
        }
        Scanner input2 = new Scanner(cars);//scanner to read from file
        Database2(cars, input2);
        //log in choices
        System.out.println("              MYRENTAL              " + "\n enter 1 to log in and 2 to sign up");
        int choice = input1.nextInt();
        if (choice == 1) {
            //if the user choose to login
            login();
        } else if (choice == 2) {
            user[4] = signUp();
            //add new user to the 4th empty slot
        }

        makeRental();

        input.close();

    }

    public static void login() {//read username and password from user and send to search method
        User currentUser = new User();
        String username;
        String password;
        int Service;
        int Region;
        int City;
        int branch;

        System.out.println("enter your username");
        username = input1.next();
        System.out.println("enter your password");
        password = input1.next();

        if (searchUser(username, password) == true) {
            System.out.println("login succes");
        } else if (searchUser(username, password) == false) {
            System.out.println("wrong password,try again");
            login();
        } else {
            System.out.println("user does not exist,try again");
            login();

        }
        //---------------------------------------------------
        //choose service
        System.out.println("please enter your choice :");
        System.out.println("1-view profile\n"
                + "2-make rental\n"
                + "3-edit current rentals\n"
                + "4-rental history");
        Service = input1.nextInt();
        System.out.println();

        while (Service > 4) {
            System.out.println("wrong choice, choose again");
            System.out.println("1-view profile\n"
                    + "2-make rental\n"
                    + "3-edit current rentals\n"
                    + "4-rental history");
            Service = input1.nextInt();
            System.out.println();

        }
        //---------------------------
        //make rental--> choose region
        if (Service == 2) {
            System.out.println("Choose the region:\n"
                    + "1-Makkah Region\n"
                    + "2-Riyadh Region");
        }
        Region = input1.nextInt();
        System.out.println();

        while (Service > 4) {
            System.out.println("wrong choice, choose again");
            System.out.println("Choose the region:\n"
                    + "1-Makkah Region\n"
                    + "2-Riyadh Region");
            Region = input1.nextInt();
            System.out.println();

        }
        //--------------------------
        //make rental--> choose city and branch
        switch (Region) {
            case 1:
                System.out.println("Choose the city:\n"
                        + "1-Makkah\n"
                        + "2-Jeddah");
                City = input1.nextInt();
                System.out.println();

                switch (City) {
                    case 1:
                        System.out.println("Enter branch number:\n"
                                + "1-Albawadi branch\n"
                                + "2-Alharamain branch");
                        branch = input1.nextInt();
                        System.out.println();

                        break;
                    case 2:
                        System.out.println("Enter branch number:\n"
                                + "1-Alfaihaa branch\n"
                                + "2-Alnaseem branch");
                        branch = input1.nextInt();
                        System.out.println();

                        break;
                }
                break;
            case 2:
                System.out.println("Choose the city:\n"
                        + "1-Riyadh");
                City = input1.nextInt();
                System.out.println();
                switch (City) {
                    case 1:
                        System.out.println("Enter branch number:\n"
                                + "1-Alshaalan branch\n"
                                + "2-Alwadi branch");
                        branch = input1.nextInt();
                        System.out.println();

                        break;

                }
                break;
        }
    }

    public static boolean searchUser(String username, String password) {
        //search for user in database and return 1 if found and 2 if password wrong and o if not exist
        for (int i = 0; i < user.length - 1; i++) {
            //&&user[i].getPassword()==password
            if (user[i].getUserName().equals(username) && user[i].getPassword().equals(password)) {
                return true;
            } else if (!user[i].getPassword().equals(password) && user[i].getUserName().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static User signUp() {//
        User newUser = User.Signup();
        System.out.println("sign-up succesful ");
        login();//go to login page after signup
        return newUser;

    }

    public static void Database(File users, Scanner input) {
        //read 3 users information from file and store in users array of object

        int i = 0;
        while (input.hasNext()) {
            user[i] = new User();
            user[i].setFname(input.next());
            user[i].setLname(input.next());
            user[i].setUserName(input.next());
            user[i].setPassword(input.next());
            user[i].setEmail(input.next());

            i++;

        }

        input.close();

    }

    public static void Database2(File cars, Scanner input2) {
        int i = 0;
        while (input2.hasNext()) {
              car[i]=new Car();
            car[i].setCompany(input2.next());
            car[i].setName(input2.next());
            car[i].setYear(input2.next());
            car[i].setType(input2.next());
            car[i].setColor(input2.next());
            car[i].setPlateNum(input2.next());
            car[i].setAvailability(input2.nextBoolean());
            car[i].setPrice(input2.nextDouble());

        }
        input2.close();
    }

    public static void makeRental() {

    }
}
