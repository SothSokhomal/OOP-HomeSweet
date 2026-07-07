package model;

import java.util.ArrayList;

public class Landlord extends Person {
    private String address;
    private String nationalID;
    private boolean isVerified;
    private boolean isActive;

    private ArrayList<House> houses = new ArrayList<>();

    private static int landlordCount = 0;

    public Landlord(String name, String username, String phone, String email, String address, String password, String nationalID,
            boolean isVerified, boolean isActive) {
        super(name, username, email, phone, password);
        setAddress(address);
        setNationalID(nationalID);
        this.isVerified = isVerified;
        this.isActive = isActive;
        landlordCount++;
    }

    // Inherits getId, getName, getEmail, getPhoneNumber from Person

    public String getAddress() {
        return address;
    }

    public String getNationalID() {
        return nationalID;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address.trim();
        } else {
            this.address = "Unknown Address";
        }
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    private void setNationalID(String nationalID) {
        if (nationalID != null && nationalID.matches("\\d{14}")) {
            this.nationalID = nationalID;
        } else {
            System.out.println("Please enter a valid 14-digit national ID");
            this.nationalID = "00000000000000";
        }
    }


    public void addProperty(House house) {
        if (!houses.contains(house)) {
            house.setLandlord(this);
            houses.add(house);
        } else {
            System.out.println("House already exists in landlord's property list: " + house.getAddress());
        }
    }

    public void removeProperty(House house) {
        house.setLandlord(null);
        houses.remove(house);
    }

    public int getTotalProperties() {
        return houses.size();
    }

    public void viewProperties() {
        System.out.println("\n--- Properties for: " + getName() + " ---");
        if (houses.isEmpty()) {
            System.out.println("No properties found.");
        } else {
            for (House h : houses)
                h.displayInfo();
        }
    }

    public static int getLandlordCount() {
        return landlordCount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Address      : " + address);
        System.out.println("National ID  : " + nationalID);
        System.out.println("Verified     : " + isVerified);
        System.out.println("Active       : " + isActive);
        System.out.println("Total Houses : " + houses.size());
    }

    @Override
    public String toString() {
        return "Landlord [id=" + getId() + ", name=" + getName() + ", phone=" + getPhoneNumber()
                + ", email=" + getEmail() + ", address=" + address + ", nationalID=" + nationalID
                + ", isVerified=" + isVerified + ", isActive=" + isActive + "]";
    }

    @Override
    public void performRole() {
        System.out.println("Landlord " + getName() + " is adding properties and generating reports.");
        main.HomeSweetMain.landlordMenu(this);
    }

    public void addProperty(String address, String city, double price) {
        House newHouse = new House(address, this, true, city, price);
        addProperty(newHouse);
        System.out.println("Landlord " + getName() + " added a new property at " + address + ", " + city + " with price $" + price);
    }

    // Overloaded methods for generateReport
    public void generateReport() {
        System.out.println("Landlord " + getName() + " generated a general property report.");
    }

    public void generateReport(String month) {
        System.out.println("Landlord " + getName() + " generated a property report for the month of " + month + ".");
    }
}
