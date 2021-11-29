package myrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


//iteration1 : make rental  Done
//iteration 2: edit rental
//iteration 3: payment
public class MyRental {

    //array of users with 4 slots
    static Customer customer[] = new Customer[4];
    //array of cars
    static Car car[] = new Car[3];
    //scanner to read from user
    static Scanner input1 = new Scanner(System.in);
    static int custID, carNum;
    static String start, end, region1, city1, branch1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        //File with users in database
        File customers = new File("usersDatabase.txt");
        if (!customers.exists()) {
            //check if the file exists.
            System.out.println("the file does not exist ");
            System.exit(0);
        } //End of if

        //File with cars in database
        File cars = new File("carsDatabase.txt");
        if (!cars.exists()) {
            //check if the file exists.
            System.out.println("the file does not exist ");
            System.exit(0);
        } //End of if

        //scanner to read from file
        Scanner input = new Scanner(customers);
        //usersDatabase method call(read 3 users from file and store in users array of objects)
        usersDatabase(customers, input);

        //scanner to read from file
        Scanner input2 = new Scanner(cars);
        //carrsDatabase method call(read 3 cars from file and store in cars array of objects)
        carsDatabase(cars, input2);

        //login choices
        System.out.println("              MYRENTAL              " + "\n enter 1 to log in and 2 to sign up");
        int choice = input1.nextInt();

        if (choice == 1) {
            //if the user chooses to login
            login();
        } else if (choice == 2) {
            //if the user chooses to suign up, add new user to the 4th empty slot
            customer[4] = signUp();
        } //End of if/else

        //--------------Home Menu--------------
        int service;

        //Choose service
        System.out.println("Please enter your choice :");
        System.out.println("1-view profile\n"
                + "2-make rental\n"
                + "3-edit current rentals\n"
                + "4-rental history");
        service = input1.nextInt();
        System.out.println();

        //If user enters a wrong choice (number), then repeat
        while (service > 4) {
            System.out.println("wrong choice, choose again");
            System.out.println("1-view profile\n"
                    + "2-make rental\n"
                    + "3-edit current rentals\n"
                    + "4-rental history");
            service = input1.nextInt();
            System.out.println();
        } //End of while loop

        //Make rental
        if (service == 2) {
            makeRental(service);
            selectDate();
            chooseCar();
            Rental rental = new Rental(start, end, region1, branch1, city1, car[carNum], custID);
            customer[custID].setRental(rental);
        } //End of if

        input.close();
        input2.close();

    } //End of main method

    //read username and password from user and send to search method
    public static void login() {
        Customer currentCustomer = new Customer();
        String username;
        String password;
        System.out.println("enter your username");
        username = input1.next();
        System.out.println("enter your password");
        password = input1.next();

        if (searchCustomer(username, password) == true) {
            System.out.println("login succes \n");

        } else if (searchCustomer(username, password) == false) {
            System.out.println("username or password is incorrect, try again");
            login();

        }  //End of if/else if/else

    } //End of login method

    public static boolean searchCustomer(String username, String password) {
        //search for user in database
        for (int i = 0; i < customer.length - 1; i++) {

            //Return true if username & password of user are both correct
            if (customer[i].getUserName().equals(username) && customer[i].getPassword().equals(password)) {
                custID = i;
                return true;

                // Return false if username is correct but the password is wrong
            } else if (!customer[i].getPassword().equals(password) && customer[i].getUserName().equals(username)) {
                return false;

            } //End of if/else if
        } //End of for loop
        return false;
    } //End of searchUser method

    public static Customer signUp() {
        Customer newCustomer = Customer.Signup();
        System.out.println("sign-up succesful ");
        login();//go to login page after sign up
        return newCustomer;

    } //End of signUp method

    public static void usersDatabase(File customers, Scanner input) {

        //read 3 users information from file and store in users array of object
        int i = 0;
        while (input.hasNext()) {
            customer[i] = new Customer();
            customer[i].setID(i);
            customer[i].setFname(input.next());
            customer[i].setLname(input.next());
            customer[i].setUserName(input.next());
            customer[i].setPassword(input.next());
            customer[i].setEmail(input.next());

            i++;

        } //End of while loop

        //input.close();
    } //End of Database method

    public static void carsDatabase(File cars, Scanner input) {

        //read 3 cars information from file and store in cars array of object
        int i = 0;
        while (input.hasNext()) {
            car[i] = new Car();
            car[i].setCompany(input.next());
            car[i].setName(input.next());
            car[i].setYear(input.next());
            car[i].setType(input.next());
            car[i].setColor(input.next());
            car[i].setPlateNum(input.next());
            car[i].setAvailability(input.nextBoolean());
            car[i].setPrice(input.nextDouble());

            i++;

        } //End of while loop

        //input.close();
    } //End of Database method

    public static void makeRental(int service) {

        int region, city, branch;

        //Choose region
        System.out.println("Choose the region:\n"
                + "1-Makkah Region\n"
                + "2-Riyadh Region");
        region = input1.nextInt();
        if (region == 1) {
            region1 = "Makkah";
        } else {
            region1 = "Riyadh";
        }
        System.out.println();

        //If user enters a wrong choice (number), then repeat
        while (region > 2) {
            System.out.println("wrong choice, choose again");
            System.out.println("Choose the region:\n"
                    + "1-Makkah Region\n"
                    + "2-Riyadh Region");
            region = input1.nextInt();
            System.out.println();
        } //End of while loop

        //Choose city & branch
        switch (region) {
            case 1: {
                //Choose city in Makkah Region
                System.out.println("Choose the city:\n"
                        + "1-Makkah\n"
                        + "2-Jeddah");
                city = input1.nextInt();
                System.out.println();

                if (city == 1) {
                    //Choose branch in Makkah
                    System.out.println("Enter branch number:\n"
                            + "1-Albawadi branch\n"
                            + "2-Alharamain branch");
                    branch = input1.nextInt();
                    System.out.println();
                    city1 = "Makkah";
                    if (branch == 1) {
                        branch1 = "Albawadi branch";
                    } else {
                        branch1 = "Alharamain branch";
                    }

                } else if (city == 2) {
                    //Choose branch in Jeddah
                    System.out.println("Enter branch number:\n"
                            + "1-Alfaihaa branch\n"
                            + "2-Alnaseem branch");
                    branch = input1.nextInt();
                    System.out.println();
                    city1 = "Jeddah";
                    if (branch == 1) {
                        branch1 = "Alfaihaa branch";
                    } else {
                        branch1 = "Alnaseem branch";
                    }
                } //End of if/else

            }
            break; //End of case 1 

            case 2: {
                //Choose city in Riyadh Region
                System.out.println("Choose the city:\n"
                        + "1-Riyadh");
                city = input1.nextInt();
                System.out.println();
                city1 = "Riyadh";

                if (city == 1) {
                    //Choose branch in Riyadh
                    System.out.println("Enter branch number:\n"
                            + "1-Alshaalan branch\n"
                            + "2-Alwadi branch");
                    branch = input1.nextInt();
                    System.out.println();
                    if (branch == 1) {
                        branch1 = "Alshaalan branch";
                    } else {
                        branch1 = "Alwadi branch";
                    }
                } //End of if
            }
            break; //End of case 2

            default: {

            }
            break; //End of default case (error)

        } //End of switch case

    } //End of makeRental method

    public static void selectDate() {
        System.out.println("Enter starting date: (DD/MM/YYYY)");
        start = input1.next();
        System.out.println("Enter ending date: (DD/MM/YYYY)");
        end = input1.next();
        System.out.println();
    }

    public static void chooseCar() {

        for (int i = 0; i < car.length; i++) {

            System.out.println("Choose a car: \n"
                    + (i + 1) + "- \n"
                    + "Model: " + car[i].getCompany() + " " + car[i].getName() + " " + car[i].getYear() + "\n"
                    + "Type: " + car[i].getType() + "\n"
                    + "Color: " + car[i].getColor() + "\n"
                    + "Price: " + car[i].getPrice() + "$"+"\n");
        } //End of for loop
        int choice = input1.nextInt();
        carNum = choice;

    } //End of chooseCar method

}  //End of class
