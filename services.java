package myrental;

import java.util.Date;
import static myrental.MyRental.input1;
import static myrental.MyRental.service;

public class services {

    private boolean delivery;
    private double deliveryFee;
    private boolean insuarnce;
    private double insuranceFee;
   

    public services() {
    }

    public services(boolean delivery, double deliveryFee, boolean insuarnce, double insuranceFee) {
        this.delivery = delivery;
        this.deliveryFee = deliveryFee;
        this.insuarnce = insuarnce;
        this.insuranceFee = insuranceFee;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public boolean isInsuarnce() {
        return insuarnce;
    }

    public void setInsuarnce(boolean insuarnce) {
        this.insuarnce = insuarnce;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public void selectService() {
        String choice;
        int choiceInt;
        System.out.println("----------------------------------------------------");
        System.out.println("    Step 5: Select services ");
        System.out.println();
        //mainServices();
        System.out.println("------------ Delivery ------------");
        System.out.println("Would you like for the car to be delivered to your location? (YES/NO)");
        choice = input1.next();
        if (choice.equalsIgnoreCase("yes")) {
            delivery();
            this.setDelivery(true);
            this.setDeliveryFee(50);
        }

        System.out.println();
        System.out.println("------------ Insurance ------------");
        System.out.println("Would you like to include insurance on the car? (YES/NO)");

        choice = input1.next();
        if (choice.equalsIgnoreCase("yes")) {
            insurance();
            this.setInsuarnce(true);
            this.setInsuranceFee(500);
        }

    }

    public void mainServices() {
        int choice;
        System.out.println("    service provided by the application      ");
        System.out.println("1- insurance \n"
                + "2- delivery \n"
                + "3- repair \n");
        choice = input1.nextInt();
        System.out.println();
        if (choice == 1) {
            System.out.println("OUR INSURANCE EVELS"
                    + "\n1-LIABILITY COVERAGE"
                    + "\n2-COMPREHENSIVE COVERAGE "
                    + "\n3-COLLISION COVERAGE");
        } else if (choice == 2) {
            System.out.println();
            System.out.println("Delivery service: \n "
                    + "You can choose to have your rented car to be delivered to your desired location!");
        } else if (choice == 3) {
            repair();
        }

    }

    public void insurance() {
        int choice;
        System.out.println("OUR INSURANCE EVELS"
                + "\n1-LIABILITY COVERAGE"
                + "\n2-COMPREHENSIVE COVERAGE "
                + "\n3-COLLISION COVERAGE");
        choice = input1.nextInt();
        System.out.println();
        System.out.println("service confirmed \nThank you for choosing our services");
    }

    public void repair() {
        String carModel;
        String poblem;
        String date;
        System.out.println("enter car type/model: ");
        carModel = input1.next();
        System.out.println("enter problem description: ");
        poblem = input1.next();
        System.out.println("enter repair date: ");
        date = input1.next();
        System.out.println();
        System.out.println("service confirmed \nThank you for choosing our services");
    }

    public void delivery() {
        String date;
        String time;
        String address;
        System.out.println("enter delivery date: (DD/MM/YYYY)");
        date = input1.next();
        System.out.println("enter delivery time: ");
        time = input1.next();
        System.out.println("enter delivery location: ");
        address = input1.nextLine();
        System.out.println();
        System.out.println("service confirmed \nThank you for choosing our services");
    }

    @Override
    public String toString() {
        return "services{" + "delivery=" + delivery + ", deliveryFee=" + deliveryFee + ", insuarnce=" + insuarnce + ", insuranceFee=" + insuranceFee + '}';
    }

} //End of class
