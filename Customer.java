package myrental;

import java.util.Date;
import static myrental.MyRental.input1;
import static myrental.MyRental.customer;

public class Customer  extends User {
    
    private String region,city,district,street;
    private int buildingNo, postNo, CVV,ID;
    private long cardNum;
    private Date expireDate;
    private Rental rental;

    public Customer() {
    }
    
    

    public Customer(int ID, String region, String city, String district, String street, int buildingNo, int postNo, int CVV, long cardNum, Date expireDate) {
        this.ID = ID;
        this.region = region;
        this.city = city;
        this.district = district;
        this.street = street;
        this.buildingNo = buildingNo;
        this.postNo = postNo;
        this.CVV = CVV;
        this.cardNum = cardNum;
        this.expireDate = expireDate;
    }

    public Customer(int ID, String region, String city, String district, String street, int buildingNo, int postNo, int CVV, long cardNum, Date expireDate, String Fname, String Lname, String UserName, String password, String Email) {
        super(Fname, Lname, UserName, password, Email);
        this.ID = ID;
        this.region = region;
        this.city = city;
        this.district = district;
        this.street = street;
        this.buildingNo = buildingNo;
        this.postNo = postNo;
        this.CVV = CVV;
        this.cardNum = cardNum;
        this.expireDate = expireDate;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
    
    

    public int getID() {
        return ID;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public int getBuildingNo() {
        return buildingNo;
    }

    public int getPostNo() {
        return postNo;
    }

    public int getCVV() {
        return CVV;
    }

    public long getCardNum() {
        return cardNum;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    
    public void displayInfo(){
        
    }
    
    public void editProfile(){
        
    }
    
    public boolean addPaymentInfo(long cardNum, Date expireDate, int CVV){
        return true;
    }
    
    public void viewRentalHistory(){
        
    }
    public static Customer Signup(){
        String Fname,Lname,Username,password,Email;
        System.out.println("enter your first and last name");
        Fname=input1.next();
        Lname=input1.next();
        System.out.println("enter username ");
        Username=input1.next();
        System.out.println("enter password");
        password=input1.next();
        System.out.println("enter email");
        Email=input1.next();
         
        Customer newUser=new Customer();
        return newUser;
   }

    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", region=" + region + ", city=" + city + ", district=" + district + ", street=" + street + ", buildingNo=" + buildingNo + ", postNo=" + postNo + ", CVV=" + CVV + ", cardNum=" + cardNum + ", expireDate=" + expireDate + '}';
    }
    
} //End of class

