package myrental;

import java.util.Date;

public class Rental {
    
    private String Startingdate, endingDate;
    private String region, branch,city;
    private Car car;
    private int custID;
    private Manager manager;
    private services service;

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
    
    public boolean makeRental(){
        return true;
    }
    
    public void editRent(){
        
    }
    
    public void makepayment(){
        
    }
    
    public void requestService(){
        
    }

    @Override
    public String toString() {
        return "Rental{" + "Startingdate=" + Startingdate + ", endingDate=" + endingDate + ", region=" + region + ", city=" + city + ", car=" + car + ", customer=" + custID + ", manager=" + manager + '}';
    }
    

} //End of class
