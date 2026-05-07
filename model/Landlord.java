package model;

import java.util.ArrayList;

public class Landlord implements Displayable {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String password;
    private String nationalID;
    private boolean isVerified;
    private boolean isActive;

    private ArrayList<House> houses = new ArrayList<>();

    public Landlord(String name, String phone, String email, String address, String password, String nationalID,
            boolean isVerified, boolean isActive) {
        this.id = idCounter++;
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
        this.setPassword(password);
        this.setNationalID(nationalID);
        this.setVerified(isVerified);
        this.setActive(isActive);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

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

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown Landlord";
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            System.out.println("Please enter a valid 10-digit phone number");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            this.email = "landlord@error.com";
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } else {
            this.address = "Unknown Address";
        }
    }

    private void setActive(boolean isActive) {
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

    private void setPassword(String password) {
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
        System.out.println("\n--- Properties for: " + name + " ---");
        if (houses.isEmpty()) {
            System.out.println("No properties found.");
        } else {
            for (House h : houses) h.displayInfo();
        }
    }

    @Override
    public String toString() {
        return "Landlord [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email +
                ", address=" + address + ", password=" + password + ", nationalID=" + nationalID +
                ", isVerified=" + isVerified + ", isActive=" + isActive + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
}
