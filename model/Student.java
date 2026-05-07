package model;
import java.util.ArrayList;

public class Student implements Displayable {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String phonNumber;
    private String password;
    private ArrayList<Contract> contracts = new ArrayList<>();
    private String nationalId;     

    public Student(String name, String email, String phonNumber, String password, Contract contract, String nationalId){
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.phonNumber = phonNumber;
        this.password = password;
        if (contract != null) {
            this.contracts.add(contract);
        }
        this.nationalId = nationalId;
    }

    private int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public String getPassword() {
        return password;
    }
    public ArrayList<Contract> getContracts() {
        return contracts;
    }
    public String getNationalId() {
        return nationalId;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Default Student";
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            this.email = "student@error.com";
        }
    }

    public void setPhonNumber(String phonNumber) {
        if (phonNumber != null && phonNumber.matches("\\d{10}")) {
            this.phonNumber = phonNumber;
        } else {
            System.out.println("Please enter a valid 10-digit phone number");
        }
    }

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
        System.out.println("\n--- Contracts for: " + name + " ---");
        if (contracts.isEmpty()) {
            System.out.println("No contracts found.");
        } else {
            for (Contract c : contracts) c.displayInfo();
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", numContracts=" + contracts.size() + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
}