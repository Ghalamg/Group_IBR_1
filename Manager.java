package myrental;

public class Manager  extends User {
    
    private String branch;

    public Manager(String branch) {
        this.branch = branch;
    }

    public Manager(String branch, String Fname, String Lname, String UserName, String password, String Email) {
        super(Fname, Lname, UserName, password, Email);
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public void confirmCustomerRental(){
        
    }
    
    
    public void addOffer(){
        
    }
    
     public void deleteOffer(){
        
    }
     
      public void deleteService(){
        
    }
      
       public void editPrice(){
        
    }
       
        public void printReport(){
        
    }

    @Override
    public String toString() {
        return "Manager{" + "branch=" + branch + '}';
    }
        
        
} //End of class

