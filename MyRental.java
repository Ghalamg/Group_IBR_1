package myrental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//iteration 1: Login, SignUp and Make rental 
//iteration 2: Make payment
//iteration 3: Select services
//iteration 4: Edit rental
public class MyRental {

    
    //array of customer information
   public static Customer customer[] = new Customer[4];
    //array of cars information
    static Car car[] = new Car[3];
    //scanner to read from user
    static Scanner input1 = new Scanner(System.in);
    static int custID, carNum;
    static String start, end, region1, city1, branch1;
    static Customer cust = null;
    static services service = new services();
    static  Rental rental = null;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        //File with users to fill in database
        File customers = new File("usersDatabase.txt");
        if (!customers.exists()) {
            //check if the file exists.
            System.out.println("the file does not exist ");
            System.exit(0);
        } //End of if

        //File with cars to fill in database
        File cars = new File("carsDatabase.txt");
        if (!cars.exists()) {
            //check if the file exists.
            System.out.println("the file does not exist ");
            System.exit(0);
        } //End of if

        //scanner to read from CustomerDatabase file
        Scanner input = new Scanner(customers);
        //CustomerDatabase method call 
        Customer costumer=new Customer();
        costumer.customerDatabase(customers, input);

        //scanner to read from carsDatabase file
        Scanner input2 = new Scanner(cars);
        //carrsDatabase method call(read 3 cars from file and store in cars array of objects)
        carsDatabase(cars, input2);

        //open application log in page
        ApplicationOpener();
        while (true) {
            //open home menu
            int menuChoice = homeMenu();

            
            if (menuChoice == 2) {
                System.out.println("----------------------------------------------------");
                System.out.println("              Make Rental              ");
                System.out.println("----------------------------------------------------");
                //iteration 1: Make rental
               
                makeRental(menuChoice);
                
                
                rental = new Rental(start, end, region1, branch1, city1, car[carNum], custID);
                customer[custID].setRental(rental);

                //iteration 3: Select services
                service.selectService();
                customer[custID].getRental().setService(service);

                //Summary of the rental
                System.out.println();
                System.out.println("----------------------------------------------------");
                System.out.println("                   Summary");
                System.out.println("----------------------------------------------------");
                Summary();

                //iteration 2: Make Payment 
                customer[custID].makePayment(custID);
            } else if (menuChoice == 3) {
                //Show the services provided by the application
                service.mainServices();
            } else if (menuChoice == 4) {
                EditRental();
            } else if (menuChoice == 5) {
                System.exit(0);
            }

            input.close();
            input2.close();
        }

    } //End of main method

    public static void ApplicationOpener() {
        //application openner 
        System.out.println("----------------------------------------------------");
        System.out.println("              MYRENTAL              " + "\n enter 1 to log in and 2 to sign up");
        System.out.println("----------------------------------------------------");
        int choice = input1.nextInt();

        //if the user chooses to login
        if (choice == 1) {
            //create a new customer 
            cust = new Customer();
            //call log in method from Customer class
            cust.login();

        } else if (choice == 2) {
            //if the user chooses to sign up, add new user to the 4th empty slot in the customers array
            Customer newCustomer = new Customer();
            //call sign up method in customer class
            newCustomer.Signup();
            customer[4] = newCustomer;
        } //End of if/else

    } //End of ApplicationOpener method

    public static int homeMenu() {

        //Home Menu
        int menuChoice;

        //Choose from menu
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("              Home Menu              ");
        System.out.println("----------------------------------------------------");
        
        System.out.println("1-View profile (not implmented)\n"
                + "2-Make rental\n"
                + "3-Services provided by the application\n"
                + "4-Edit or remove rentals\n"
                + "5-Log out ");
        System.out.println();
        System.out.println("Please enter your choice :");
        menuChoice = input1.nextInt();
        System.out.println();

        //If user enters a wrong choice (number), then repeat
        while (menuChoice > 5) {
            System.out.println("wrong choice, choose again");
            homeMenu();

        } //End of while loop
        return menuChoice;
    } // End of homeMenu method

   

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

     
    } //End of carsDatabase method

    public static void makeRental(int menuChoice) {

        int region, city, branch;

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
         selectDate();
         chooseCar();

    } //End of makeRental method

    public static void selectDate() {
        System.out.println("    Step3: Select rental starting date and ending date: ");
        System.out.println();
        System.out.println("Enter starting date: (DD/MM/YYYY)");
        start = input1.next();
        System.out.println("Enter ending date: (DD/MM/YYYY)");
        end = input1.next();
        System.out.println();

    } //End of selectDate method

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

    public static void Summary() {
        double ttl = 0;

        System.out.println("Duration: " + customer[custID].getRental().getStartingdate() + " to " + customer[custID].getRental().getEndingDate());
        System.out.println();
        System.out.println("City: " + customer[custID].getRental().getCity() + "        Branch: " + customer[custID].getRental().getBranch());
        System.out.println();
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
        System.out.println();
    } //End of Summary method

    public static void EditRental() {
        int rentalNumber;
        System.out.println("choose your option please:\n"
                + "1-Edit\n"
                + "2-remove");
        System.out.println();
        int option = input1.nextInt();
        if (option == 1) {
            System.out.println("----------------------------------------------------");
            System.out.println("please choose which rental you want to edit:");
            System.out.println("----------------------------------------------------");
            EditSummary();
            System.out.print("Please write the number of rental here:");
            rentalNumber = input1.nextInt();
            EditRentalChoice(rentalNumber);
           
            Rental editrental = new Rental(start, end, region1, branch1, city1, car[carNum], custID);
            customer[custID].setRental(editrental);

        } else if (option == 2) {
            
            
           rental.removeRental();
           
        }
        while (option > 2) {
            System.out.println("Invalid number enter again please:");
            System.out.println("choose your option please:"
                    + "1-Edit\n"
                    + "2-remove");

        }

    }//End of EditRental method

    public static void EditRentalChoice(int rentalNumber) {

        System.out.println("----------------------------------------------------");
        System.out.println("              Edit Rental              ");
        System.out.println("----------------------------------------------------");
        makeRental(1);
        service.selectService();
        customer[custID].getRental().setService(service);
        customer[custID].makePayment(custID);
        System.out.println();
        System.out.println("Rental editted successfully, Thank you for choosing us !");

    } //End of EditRentalChoice method


    public static void EditSummary() {
        System.out.println("1- ");
        Summary();
    }// End of EditSummary method

}  //End of class
