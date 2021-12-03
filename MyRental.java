package myrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//iteration1 : make rental 
//iteration 2: make payment
//iteration 3: select services
//iteration 4: Edit rental
public class MyRental {

    //array of users with 4 slots
    static Customer customer[] = new Customer[4];
    //array of cars with 3 slots
    static Car car[] = new Car[3];
    //scanner to read from user
    static Scanner input1 = new Scanner(System.in);
    //attributes
    static int custID, carNum;
    static String start, end, region1, city1, branch1;
    static Customer cust = null;
    static services service = new services();

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
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
        System.out.println("----------------------------------------------------");
        System.out.println("              MYRENTAL              " + "\n enter 1 to log in and 2 to sign up");
        System.out.println("----------------------------------------------------");
        int choice = input1.nextInt();

        if (choice == 1) {
            //if the user chooses to login
            cust = new Customer();
            cust.login();
        } else if (choice == 2) {
            //if the user chooses to suign up, add new user to the 4th empty slot
            Customer newCustomer = new Customer();
            newCustomer.Signup();
            customer[4] = newCustomer;
        } //End of if/else

        //--------------Home Menu--------------
        int menuChoice;

        //Choose service
        while (true) {
            System.out.println();
            //System.out.println("----------------------------------------------------");
            System.out.println("Please enter your choice :");
            System.out.println("1-view profile\n"
                    + "2-make rental\n"
                    + "3-services\n"
                    + "4-edit current rentals\n"
                    + "5-Log Out");
            menuChoice = input1.nextInt();
            System.out.println();

            //If user enters a wrong choice (number), then repeat
            while (menuChoice > 5) {
                System.out.println("wrong choice, choose again");
                System.out.println("1-view profile\n"
                        + "2-make rental\n"
                        + "3-services\n"
                        + "4-edit current rentals\n"
                        + "5-Log Out"
                );
                menuChoice = input1.nextInt();
                System.out.println();

            } //End of while loop

            //iteration1: Make rental 
            if (menuChoice == 2) {
                makeRental(menuChoice);
                selectDate();
                chooseCar();
                Rental rental = new Rental(start, end, region1, branch1, city1, car[carNum], custID);
                customer[custID].setRental(rental);
            } else if (menuChoice == 3) {
                service.mainServices();
            } else if (menuChoice == 4) {
                EditRental();

            } else if (menuChoice == 5) {
                System.exit(0);
            }

//End of if
            //iteration 3: Select services
            service.selectService();
            customer[custID].getRental().setService(service);

            //summary
            double ttl = 0;
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("Summary: ");
            System.out.println("Duration: " + customer[custID].getRental().getStartingdate() + " to " + customer[custID].getRental().getEndingDate());
            System.out.println();
            System.out.println("City: " + customer[custID].getRental().getCity() + "Branch: " + customer[custID].getRental().getBranch());
            System.out.println("Car details: ");
            System.out.println("Model " + customer[custID].getRental().getCar().getCompany() + " " + customer[custID].getRental().getCar().getName() + " " + customer[custID].getRental().getCar().getYear());
            System.out.println("Type " + customer[custID].getRental().getCar().getType());
            System.out.println("Color " + customer[custID].getRental().getCar().getColor());
            System.out.println("price: $" + customer[custID].getRental().getCar().getPrice());
            ttl += customer[custID].getRental().getCar().getPrice();
            System.out.println();
            System.out.println("Services: ");
            if (customer[custID].getRental().getService().isDelivery() == true) {
                System.out.println("Delivery: Yes");
                System.out.println("Delivery fee: " + customer[custID].getRental().getService().getDeliveryFee());
                ttl += customer[custID].getRental().getService().getDeliveryFee();
            } else {
                System.out.println("Delivery: No");
            }
            if (customer[custID].getRental().getService().isInsuarnce() == true) {
                System.out.println("Insurance: Yes");
                System.out.println("Insurance fee: " + customer[custID].getRental().getService().getInsuranceFee());
                ttl += customer[custID].getRental().getService().getInsuranceFee();
            } else {
                System.out.println("Insurance: No");
            }
            System.out.println();

            System.out.println("Total Price: $" + ttl);

            //iteration 2: Make Payment 
            customer[custID].makePayment(custID);

            input.close();
            input2.close();

        } //End of main method
    }

    /*
    public static Customer signUp() {
        Customer CurrCustomer = new Customer();
        CurrCustomer.Signup();
        System.out.println("sign-up succesful ");
        CurrCustomer.login();//go to login page after sign up
        return CurrCustomer;

    } //End of signUp method */
    public static void usersDatabase(File customers, Scanner input) {

        //read 3 users information from file and store in users array of object
        int i = 0;
        while (input.hasNext()) {
            customer[i] = new Customer();
            customer[i].setID(i);
            customer[i].setfName(input.next());
            customer[i].setlName(input.next());
            customer[i].setUsername(input.next());
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

    public static void makeRental(int menuChoice) {

        int region, city, branch;
        System.out.println("----------------------------------------------------");
        System.out.println("              Make Rental              ");
        System.out.println("----------------------------------------------------");
        //Choose region
        System.out.println("    Step1: Choose region: ");
        System.out.println();
        System.out.println("1-Makkah Region\n"
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
                System.out.println("    Step2: Choose city: ");
                System.out.println();
                System.out.println("1-Makkah\n"
                        + "2-Jeddah");
                city = input1.nextInt();
                System.out.println();

                if (city == 1) {
                    //Choose branch in Makkah
                    System.out.println("    Step3: Choose branch: ");
                    System.out.println();
                    System.out.println("1-Albawadi branch\n"
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
                    System.out.println("    Step3: Choose branch: ");
                    System.out.println();
                    System.out.println("1-Alfaihaa branch\n"
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
                System.out.println("    Step2: Choose city: ");
                System.out.println();
                System.out.println("1-Riyadh");
                city = input1.nextInt();
                System.out.println();
                city1 = "Riyadh";

                if (city == 1) {
                    //Choose branch in Riyadh
                    System.out.println("    Step3: Choose branch: ");
                    System.out.println();
                    System.out.println("1-Alshaalan branch\n"
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
        System.out.println("    Step3: Select rental starting date and ending date: ");
        System.out.println();
        System.out.println("Enter starting date: (DD/MM/YYYY)");
        start = input1.next();
        System.out.println("Enter ending date: (DD/MM/YYYY)");
        end = input1.next();
        System.out.println();

    }

    public static void chooseCar() {
        System.out.println("    Step4: Choose car: ");
        System.out.println();
        int j = 1;
        for (int i = 0; i < car.length; i++) {

            System.out.println((j) + "- \n"
                    + "Model: " + car[i].getCompany() + " " + car[i].getName() + " " + car[i].getYear() + "\n"
                    + "Type: " + car[i].getType() + "\n"
                    + "Color: " + car[i].getColor() + "\n"
                    + "Price: " + car[i].getPrice() + "$" + "\n");
            j++;
        } //End of for loop
        int choice = input1.nextInt();
        //because the array is starts from zero
        choice--;
        carNum = choice;

    } //End of chooseCar method

    public static void EditRental() {

        System.out.println("choose your option please:\n"
                + "1-Edit\n"
                + "2-remove");
        System.out.println();
        int edit = input1.nextInt();
        if (edit == 1) {
            System.out.println("----------------------------------------------------");
            System.out.println("please choose which rental you want to edit:");
            System.out.println("----------------------------------------------------");
            EditSummary();
            System.out.print("Please write the number of rental here:");

            int choice = input1.nextInt();
            EditRentalChoice();
            selectDate();
            chooseCar();
            Rental editrental = new Rental(start, end, region1, branch1, city1, car[carNum], custID);
            customer[custID].setRental(editrental);
             System.out.println("----------------------------------------------------");
             System.out.println("rental edited successfly!!!");
              System.out.println("----------------------------------------------------");
        } else if (edit == 2) {
            System.out.println("----------------------------------------------------");
            System.out.println("please choose which rental you want to remove:");
            System.out.println("----------------------------------------------------");
            EditSummary();
            System.out.print("Please write the number of rental here:");
            int choice = input1.nextInt();
            removeRental();
             System.out.println("----------------------------------------------------");
            System.out.println("rental removed successfly!!!");
             System.out.println("----------------------------------------------------");
        }
        while (edit > 2) {
            System.out.println("Invalid number enter again please:");
            System.out.println("choose your option please:"
                    + "1-Edit\n"
                    + "2-remove");

        }

    }

    public static void EditRentalChoice() {

        int region, city, branch;
        System.out.println("----------------------------------------------------");
        System.out.println("              Edit Rental              ");
        System.out.println("----------------------------------------------------");
        //Choose region
        System.out.println("    Step1: Choose region: ");
        System.out.println();
        System.out.println("1-Makkah Region\n"
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
                System.out.println("    Step2: Choose city: ");
                System.out.println();
                System.out.println("1-Makkah\n"
                        + "2-Jeddah");
                city = input1.nextInt();
                System.out.println();

                if (city == 1) {
                    //Choose branch in Makkah
                    System.out.println("    Step3: Choose branch: ");
                    System.out.println();
                    System.out.println("1-Albawadi branch\n"
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
                    System.out.println("    Step3: Choose branch: ");
                    System.out.println();
                    System.out.println("1-Alfaihaa branch\n"
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
                System.out.println("    Step2: Choose city: ");
                System.out.println();
                System.out.println("1-Riyadh");
                city = input1.nextInt();
                System.out.println();
                city1 = "Riyadh";

                if (city == 1) {
                    //Choose branch in Riyadh
                    System.out.println("    Step3: Choose branch: ");
                    System.out.println();
                    System.out.println("1-Alshaalan branch\n"
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

    } //End of EditRentalChoice method

    public static void removeRental() {

    }

    public static void EditSummary() {
        double ttl = 0;

        System.out.println("1- ");
        System.out.println("Duration: " + customer[custID].getRental().getStartingdate() + " to " + customer[custID].getRental().getEndingDate());
        System.out.println();
        System.out.println("City: " + customer[custID].getRental().getCity() + "Branch: " + customer[custID].getRental().getBranch());
        System.out.println("Car details: ");
        System.out.println("Model " + customer[custID].getRental().getCar().getCompany() + " " + customer[custID].getRental().getCar().getName() + " " + customer[custID].getRental().getCar().getYear());
        System.out.println("Type " + customer[custID].getRental().getCar().getType());
        System.out.println("Color " + customer[custID].getRental().getCar().getColor());
        System.out.println("price: $" + customer[custID].getRental().getCar().getPrice());
        ttl += customer[custID].getRental().getCar().getPrice();
        System.out.println();
        System.out.println("Services: ");
        if (customer[custID].getRental().getService().isDelivery() == true) {
            System.out.println("Delivery: Yes");
            System.out.println("Delivery fee: " + customer[custID].getRental().getService().getDeliveryFee());
            ttl += customer[custID].getRental().getService().getDeliveryFee();
        } else {
            System.out.println("Delivery: No");
        }
        if (customer[custID].getRental().getService().isInsuarnce() == true) {
            System.out.println("Insurance: Yes");
            System.out.println("Insurance fee: " + customer[custID].getRental().getService().getInsuranceFee());
            ttl += customer[custID].getRental().getService().getInsuranceFee();
        } else {
            System.out.println("Insurance: No");
        }
        System.out.println();

        System.out.println("Total Price: $" + ttl);
    }

}  //End of class

