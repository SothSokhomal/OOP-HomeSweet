package model;

import java.util.ArrayList;
import interfaces.Displayable;

public class Student extends Person implements Displayable {
    private ArrayList<Contract> contracts = new ArrayList<>();
    private String nationalId;

    private static int studentCount = 0;

    public Student(String name, String username, String email, String phoneNumber, String password, String nationalId) {
        super(name, username, email, phoneNumber, password);
        setNationalId(nationalId);
        studentCount++;
    }

    // Inherits getId, getName, getEmail, getPhoneNumber, getPassword from Person

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public String getNationalId() {
        return nationalId;
    }

    @Override
    public void setPassword(String password) {
        if (password != null && password.length() >= 8 && password.matches(".*[!@#$%^&*()].*")) {
            super.setPassword(password);
        } else {
            System.out.println("Warning: Password must be at least 8 characters and contain a special character (!@#$%^&*()). Setting default password.");
            super.setPassword("SecurityError123!");
        }
    }

    public void setContract(Contract contract) {
        if (contract != null && !contracts.contains(contract)) {
            contracts.add(contract);
        }
    }

    public void setNationalId(String nationalId) {
        if (nationalId != null && nationalId.matches("\\d{14}")) {
            this.nationalId = nationalId;
        } else {
            System.out.println("Please enter a valid 14-digit national ID");
            this.nationalId = "00000000000000";
        }
    }

    public void viewContracts() {
        System.out.println("\n--- Contracts for: " + getName() + " ---");
        if (contracts.isEmpty()) {
            System.out.println("No contracts found.");
        } else {
            for (Contract c : contracts)
                c.displayInfo();
        }
    }

    public static int getStudentCount() {
        return studentCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID   : " + getId());
        System.out.println("Name         : " + getName());
        System.out.println("Email        : " + getEmail());
        System.out.println("Phone Number : " + getPhoneNumber());
        System.out.println("National ID  : " + nationalId);
        System.out.println("Contracts    : " + contracts.size());
    }

    @Override
    public String toString() {
        return "Student [id=" + getId() + ", name=" + getName() + ", numContracts=" + contracts.size() + "]";
    }

    @Override
    public void performRole() {
        System.out.println("Student " + getName() + " is viewing houses and managing bills.");
    }

    // Overloaded methods for viewHouses
    public void viewHouses() {
        System.out.println("Student " + getName() + " is viewing all available houses.");
    }

    public void viewHouses(String location) {
        System.out.println("Student " + getName() + " is viewing houses located in: " + location);
    }

    // Overloaded methods for payBill
    public void payBill(double amount) {
        System.out.println("Student " + getName() + " paid $" + amount + " using default payment method.");
    }

    public void payBill(double amount, String paymentMethod) {
        System.out.println("Student " + getName() + " paid $" + amount + " using " + paymentMethod + ".");
    }

    // Overloaded methods for bookHouse
    public void bookHouse(House house) {
        System.out.println("Student " + getName() + " booked House ID: " + house.getId() + " for a standard term.");
    }

    public void bookHouse(House house, int durationInMonths) {
        System.out.println("Student " + getName() + " booked House ID: " + house.getId() + " for " + durationInMonths + " months.");
    }
}
