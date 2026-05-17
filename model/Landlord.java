package model;

import java.util.ArrayList;

import interfaces.Displayable;

public class Landlord extends Person implements Displayable {
    private static int idCounter = 1;
    private String address;
    private String password;
    private String nationalID;
    private boolean isVerified;
    private boolean isActive;

    private ArrayList<House> houses = new ArrayList<>();

    public Landlord(String name, String phone, String email, String address, String password, String nationalID,
            boolean isVerified, boolean isActive) {
        super(idCounter++, name, email, phone, password);
        this.setAddress(address);
        this.setNationalID(nationalID);
        this.setVerified(isVerified);
        this.setActive(isActive);
    }

    // Inherits getId, getName, getPhoneNumber, getEmail from Person

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
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

    public void addHouse(House h) {
        if (!houses.contains(h)) {
            houses.add(h);
        }
    }

    // Inherits setName, setPhoneNumber, setEmail from Person

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } else {
            this.address = "Unknown Address";
        }
    }

    void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    private void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    private void setNationalID(String nationalID) {
        if (nationalID != null && nationalID.matches("\\d{14}")) {
            this.nationalID = nationalID;
        } else {
            System.out.println("Please enter a valid 14-digit national ID");
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 6) {
            this.password = password;
        } else {
            System.out.println("Password must be at least 6 characters long.");
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

    public void LandlordViewProperties() {
        System.out.println("\n--- Properties for: " + getName() + " ---");
        if (houses.isEmpty()) {
            System.out.println("No properties found.");
        } else {
            for (House h : houses)
                h.displayInfo();
        }
    }

    @Override
    public String toString() {
        return "Landlord [id=" + getId() + ", name=" + getName() + ", phone=" + getPhoneNumber() + ", email=" + getEmail() +
                ", address=" + address + ", password=" + password + ", nationalID=" + nationalID +
                ", isVerified=" + isVerified + ", isActive=" + isActive + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
}
