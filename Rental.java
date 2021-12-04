package myrental;

import java.util.Date;
import static myrental.MyRental.input1;

public class Rental {
    
    private String Startingdate, endingDate;
    private String region, branch,city;
    private Car car;
    private int custID;
    private Manager manager;
    private services service;
    /*
    -startingdate: String
    -endingdate: String
    -region: String
    -branch: String
    -city: String
    -car: Car
    custID: int
    -manager:Manager
    -service: services
    
    
    */

    public Rental() {
    }

    
    
    public Rental(String Startingdate, String endingDate, String region,String branch, String city, Car car, int custID) {
        this.Startingdate = Startingdate;
        this.endingDate = endingDate;
        this.region = region;
        this.branch=branch;
        this.city = city;
        this.car = car;
        this.custID = custID;
    }
    
    
    public Rental(String Startingdate, String endingDate, String region, String city, Car car, int custID, Manager manager) {
        this.Startingdate = Startingdate;
        this.endingDate = endingDate;
        this.region = region;
        this.city = city;
        this.car = car;
        this.custID = custID;
        this.manager = manager;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public void setStartingdate(String Startingdate) {
        this.Startingdate = Startingdate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public services getService() {
        return service;
    }

    public void setService(services service) {
        this.service = service;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(int custID) {
        this.custID = custID;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getStartingdate() {
        return Startingdate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public Car getCar() {
        return car;
    }

    public int getCustomer() {
        return custID;
    }

    public Manager getManager() {
        return manager;
    }
    
   

    public void  removeRental() {
      
        System.out.println();
       
        System.out.println("Are you sure you want to remove rental? (YES/NO)");
        String choice = input1.next();
        if (choice.equalsIgnoreCase("Yes")) {
            System.out.println();
            System.out.println("Rental is successfully removed, hope to see you again !");
        } else if (choice.equalsIgnoreCase("No")) {
            //EditRental();
        } else {
            System.out.println("Wrong selection, Try again");
            removeRental();
        }
        
       
    }// End of removeRental method
    
    @Override
    public String toString() {
        return "Rental{" + "Startingdate=" + Startingdate + ", endingDate=" + endingDate + ", region=" + region + ", city=" + city + ", car=" + car + ", customer=" + custID + ", manager=" + manager + '}';
    }
    

} //End of class
