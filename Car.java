package myrental;

public class Car {
    
    private String model,color,plateNum,branch,city;
    private boolean availability;
    private double price;

    public Car(String model, String color, String plateNum, String branch, String city, boolean availability, double price) {
        this.model = model;
        this.color = color;
        this.plateNum = plateNum;
        this.branch = branch;
        this.city = city;
        this.availability = availability;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" + "model=" + model + ", color=" + color + ", plateNum=" + plateNum + ", branch=" + branch + ", city=" + city + ", availability=" + availability + ", price=" + price + '}';
    }
    
    
} //End of class
