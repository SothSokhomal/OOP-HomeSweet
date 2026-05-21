package model;

import java.util.ArrayList;
import interfaces.Displayable;

public class Student extends Person implements Displayable {
    private ArrayList<Contract> contracts = new ArrayList<>();
    private String nationalId;

    private static int studentCount = 0;

    public Student(String name, String email, String phoneNumber, String password, String nationalId) {
        super(name, email, phoneNumber, password);
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
}
