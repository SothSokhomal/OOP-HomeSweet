package model;
import java.util.ArrayList;

public class Admin implements Searchable {
    private String name;
    private String email;
    private String password;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Landlord> landlords = new ArrayList<>();
    private ArrayList<House> houses = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();

    public Admin(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addStudent(Student s) { students.add(s); }
    public void addLandlord(Landlord l) { landlords.add(l); }
    public void addHouse(House h) { houses.add(h); }
    public void addContract(Contract c) { contracts.add(c); }

    public void viewStudents() {
        System.out.println("\n--- Student List ---");
        for(Student s : students) s.displayInfo();
    }
    public void viewLandlords() {
        System.out.println("\n--- Landlord List ---");
        for(Landlord l : landlords) l.displayInfo();
    }
    public void viewHouses() {
        System.out.println("\n--- House List ---");
        for(House h : houses) h.displayInfo();
    }
    public void viewAllPayments() {
        System.out.println("\n--- Payment History ---");
        for(Payment p : payments) p.displayInfo();
    }

    public void viewContracts() {
        System.out.println("\n--- Contract List ---");
        for(Contract c : contracts) c.displayInfo();
    }

    @Override
    public void search(String keyword) {
        System.out.println("\n--- Search Results for: " + keyword + " ---");
        boolean found = false;
        
        System.out.println("Students:");
        for(Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                s.displayInfo();
                found = true;
            }
        }
        
        System.out.println("Landlords:");
        for(Landlord l : landlords) {
            if (l.getName().toLowerCase().contains(keyword.toLowerCase())) {
                l.displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No matching records found.");
        }
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }
}