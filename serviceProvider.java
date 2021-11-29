package myrental;

import java.util.Date;

public class serviceProvider extends User {
    private String branch, serviceType;
    private Date serviceDate;
    private long insurranceNum;

    public serviceProvider() {
    }

    public serviceProvider(String Fname, String Lname, String UserName, String password, String Email) {
        super(Fname, Lname, UserName, password, Email);
    }

    public serviceProvider(String branch, String serviceType, Date serviceDate, long insurranceNum) {
        this.branch = branch;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.insurranceNum = insurranceNum;
    }

    /*public serviceProvider(String branch, String serviceType, Date serviceDate, long insurranceNum, String Fname, String Lname, String UserName, String password, String Email) {
        super(Fname, Lname, UserName, password, Email);
        this.branch = branch;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.insurranceNum = insurranceNum;
    }*/

    public String getBranch() {
        return branch;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public long getInsurranceNum() {
        return insurranceNum;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public void setInsurranceNum(long insurranceNum) {
        this.insurranceNum = insurranceNum;
    }
    
    //
    public void provideService(){
        /*
        
        */
    }

    @Override
    public String toString() {
        return "serviceProvider{" + "branch=" + branch + ", serviceType=" + serviceType + ", serviceDate=" + serviceDate + ", insurranceNum=" + insurranceNum + '}';
    }
    
    
} //End of class

