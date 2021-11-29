package myrental;

public class services {
    private String serviceType;
    private double price;

    public services(String serviceType, double price) {
        this.serviceType = serviceType;
        this.price = price;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getPrice() {
        return price;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "services{" + "serviceType=" + serviceType + ", price=" + price + '}';
    }
    
    
} //End of class

