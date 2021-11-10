package myrental;

import java.util.Date;

public class Rental {
    
    private Date Startingdate, endingDate;
    private String region, city;
    private Car car;
    private Customer customer;
    private Manager manager;

    public Rental(Date Startingdate, Date endingDate, String region, String city, Car car, Customer customer, Manager manager) {
        this.Startingdate = Startingdate;
        this.endingDate = endingDate;
        this.region = region;
        this.city = city;
        this.car = car;
        this.customer = customer;
        this.manager = manager;
    }

    public void setStartingdate(Date Startingdate) {
        this.Startingdate = Startingdate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Date getStartingdate() {
        return Startingdate;
    }

    public Date getEndingDate() {
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

    public Customer getCustomer() {
        return customer;
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
        return "Rental{" + "Startingdate=" + Startingdate + ", endingDate=" + endingDate + ", region=" + region + ", city=" + city + ", car=" + car + ", customer=" + customer + ", manager=" + manager + '}';
    }
    

} //End of class
