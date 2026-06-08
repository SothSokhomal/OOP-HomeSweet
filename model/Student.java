package model;

import java.util.ArrayList;

public class Student extends Person {
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
        super.displayInfo();
        System.out.println("National ID  : " + nationalId);
        System.out.println("Contracts    : " + contracts.size());
    }

    // OVERRIDING: each subclass describes its own role
    @Override
    public void performRole() {
        System.out.println("Student " + getName() + " is viewing houses and managing bills.");
    }

    // Overloaded methods for viewHouses
    public void viewHouses() { // view all houses
        System.out.println("Student " + getName() + " is viewing all available houses.");
    }

    public void viewHouses(String location) { // view houses filtered by location
        System.out.println("Student " + getName() + " is viewing houses located in: " + location);
    }

    // Overloaded methods for payBill
    public void payBill(double amount) { // default payment method
        System.out.println("Student " + getName() + " paid $" + amount + " using default payment method.");
    }

    public void payBill(double amount, String paymentMethod) { // payment with chosen method
        System.out.println("Student " + getName() + " paid $" + amount + " using " + paymentMethod + ".");
    }

    // Overloaded methods for bookHouse
    public void bookHouse(House house) { // quick booking with standard term
        System.out.println("Student " + getName() + " booked House ID: " + house.getId() + " for a standard term.");
    }

    public void bookHouse(House house, String startDate, String endDate) { // booking with specific dates
        System.out.println("Student " + getName() + " booked House ID: " + house.getId() + " from " + startDate + " to " + endDate + ".");
    }

    // Issue 1 fix: added toString() — consistent with all other model classes
    @Override
    public String toString() {
        return "Student [id=" + getId() + ", name=" + getName() +
               ", nationalId=" + nationalId + ", contracts=" + contracts.size() + "]";
    }
}