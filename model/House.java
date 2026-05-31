package model;

import interfaces.Displayable;
import interfaces.StatusManageable;

public class House implements Displayable, StatusManageable {
    private static int nextHouseId = 1;
    private int id;
    private String address;
    private boolean isAvailable;
    private Landlord landlord;
    private String city;
    private double rentPrice;

    private static int houseCount = 0;

    public House(String address, Landlord landlord, boolean isAvailable, String city, double rentPrice) {
        this.id = nextHouseId++;
        setAddress(address);
        setLandlord(landlord);
        setCity(city);
        this.isAvailable = isAvailable;
        setRentPrice(rentPrice);
        houseCount++;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public String getCity() {
        return city;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address.trim();
        } else {
            this.address = "Unknown Address";
        }
    }

    // Named methods preferred by professor
    public void markAvailable() {
        this.isAvailable = true;
    }

    public void markUnavailable() {
        this.isAvailable = false;
    }

    // Keep setAvailable for backward compatibility
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    //overloaded method for setRentPrice
    public void setRentPrice(double rentPrice) {
        if (rentPrice > 0) {
            this.rentPrice = rentPrice;
        } else {
            throw new IllegalArgumentException("Rent price must be positive: " + rentPrice);
        }
    }

    public void setRentPrice(double rentPrice, double discountPercent) {
        double discounted = rentPrice - (rentPrice * discountPercent / 100);
        setRentPrice(discounted);
        System.out.println("Discounted rent applied: $" + discounted);
    }

    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city.trim();
        } else {
            this.city = "Unknown City";
        }
    }

    public static int getHouseCount() {
        return houseCount;
    }

    @Override
    public String getStatusText() {
        return isAvailable ? "Available" : "Unavailable";
    }

    @Override
    public void displayStatus() {
        System.out.println("House Status: " + getStatusText());
    }

    @Override
    public void displayInfo() {
        System.out.println("House ID     : " + id);
        System.out.println("Address      : " + address);
        System.out.println("City         : " + city);
        System.out.println("Monthly Rent : $" + rentPrice);
        System.out.println("Status       : " + getStatusText());
        if (landlord != null) {
            System.out.println("Landlord     : " + landlord.getName());
            System.out.println("Landlord Tel : " + landlord.getPhoneNumber());
        } else {
            System.out.println("Landlord     : No landlord assigned");
        }
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", address=" + address + ", city=" + city +
                ", landlord=" + (landlord != null ? landlord.getName() : "None") +
                ", isAvailable=" + isAvailable + ", rentPrice=" + rentPrice + "]";
    }
}
