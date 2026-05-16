package model;

import java.util.ArrayList;

import interfaces.Displayable;

public class Student extends Person implements Displayable {
    private static int idCounter = 1;
    private String password;
    private ArrayList<Contract> contracts = new ArrayList<>();
    private String nationalId;

    public Student(String name, String email, String phonNumber, String password, Contract contract,
            String nationalId) {
        super(idCounter++, name, email, phonNumber);
        this.password = password;
        if (contract != null) {
            this.contracts.add(contract);
        }
        this.nationalId = nationalId;
    }

    // Inherits getters for id, name, email, phoneNumber from Person

    public String getPassword() {
        return password;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public String getNationalId() {
        return nationalId;
    }

    // Inherits setters for id, name, email, phoneNumber from Person

    public void setPassword(String password) {
        if (password != null && password.length() >= 8 && password.matches(".*[!@#$%^&*()].*")) {
            this.password = password;
        } else {
            this.password = "SecurityError123!";
        }
    }

    public void setContract(Contract contract) {
        if (contract != null) {
            this.contracts.add(contract);
        }
    }

    public void setNationalId(String nationalId) {
        if (nationalId != null && nationalId.matches("\\d{14}")) {
            this.nationalId = nationalId;
        } else {
            System.out.println("Please enter a valid 14-digit national ID");
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

    @Override
    public String toString() {
        return "Student [id=" + getId() + ", name=" + getName() + ", numContracts=" + contracts.size() + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
}