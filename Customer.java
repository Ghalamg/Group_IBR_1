package myrental;

import java.util.Date;
import static myrental.MyRental.customer;
import static myrental.MyRental.input1;

public class Customer  extends User {
    
    private String fName,lName,username,password,email,cardNum;
            //,region,city,district,street;
    private int CVV,ID;
           // buildingNo, postNo, ;
    
    private String expireDate;
    private Rental rental;

    public Customer() {
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Customer(String fName, String lName, String username, String password, String email, int CVV, int ID, String cardNum, String expireDate, Rental rental) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.CVV = CVV;
        this.ID = ID;
        this.cardNum = cardNum;
        this.expireDate = expireDate;
        this.rental = rental;
    }

    public Customer(String fName, String lName, String username, String password, String email) {
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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

    /*public String getRegion() {
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
    }*/

    public int getCVV() {
        return CVV;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
/*
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
    }*/

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    
   /* public void displayInfo(){
        
    }
    
    public void editProfile(){
        
    }*/
    
    public boolean addPaymentInfo(long cardNum, Date expireDate, int CVV){
        return true;
    }
    
    public void viewRentalHistory(){
        
    }
    
    public  Customer Signup(){
      
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
         
        Customer newUser=new Customer(Fname,Lname,Username,password,Email);
        System.out.println("sign-up succesful ");
        login();
        return newUser;
   }
    
    //read username and password from user and send to search method
    public  void login() {
        
        String username;
        String password;
        Customer currentCustomer = new Customer( this.username, this.password);
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

    public  boolean searchCustomer(String username, String password) {
        //search for user in database
        for (int i = 0; i < customer.length; i++) {

            //Return true if username & password of user are both correct
            if (customer[i].getUsername().equals(username) && customer[i].getPassword().equals(password)) {
                //custID = i;
                return true;

                // Return false if username is correct but the password is wrong
            } else if (!customer[i].getPassword().equals(password) && customer[i].getUsername().equals(username)) {
                return false;

            } //End of if/else if
        } //End of for loop
        return false;
    } //End of searchUser method

    public void makePayment(int Id){
        //cardnum, cvv , exp date,
        
         System.out.println("----------------------------------------------------");
        System.out.println("    Step 6: Payment ");
        System.out.println();
        System.out.println("Select payment method: \n"
        + "1- Credit card \n"
        + "2- Apple pay (not implemented) \n"
        + "3- Cash (not implemented)");
        int choice = input1.nextInt();
        if(choice==1){
            System.out.println();
        System.out.println("Enter card number: (no spaces between numbers)");
        String cardnumber = input1.next();
        System.out.println("Enter card expiry date (MM/YY): ");
        String expirydate = input1.next();
        System.out.println("Enter CVV number (behind the card): ");
        int cvv= input1.nextInt();
       customer[Id].setCardNum(cardnumber);
       customer[Id].setExpireDate(expirydate);
       customer[Id].setCVV(cvv);
        }else{
            System.out.println("This method is not available yet! Select different method");
            makePayment(Id);
        }
         System.out.println("----------------------------------------------------");
      
       
        
     }
 
    @Override
    public String toString() {
        return "Customer{ id:" +ID+ ", first name: " + fName + ", last name: " + lName + ", username: " + username + ", password: " + password + ", email: " + email + '}';
    }
    
} //End of class

