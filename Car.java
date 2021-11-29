package myrental;

public class Car {
    
    private String company, name, year, color, plateNum, type;
    private boolean availability;
    private double price;

    public Car() {
    }

    public Car(String company, String name, String year, String color, String plateNum, String type, boolean availability, double price) {
        this.company = company;
        this.name = name;
        this.year = year;
        this.color = color;
        this.plateNum = plateNum;
        this.type = type;
        this.availability = availability;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Car{" + "company=" + company + ", name=" + name + ", year=" + year + ", color=" + color + ", plateNum=" + plateNum + ", type=" + type + ", availability=" + availability + ", price=" + price + '}';
    }
    
} //End of class
