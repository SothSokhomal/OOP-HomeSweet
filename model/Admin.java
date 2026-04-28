package model;

import java.util.ArrayList;

public class Admin {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String password;
    

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Landlord> landlords = new ArrayList<>();
    private ArrayList<House> houses = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();

    public Admin(String name, String email, String password){
        this.id = idCounter++;
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
    }

    //--- CRUD OPERATIONS ---

    //Manage Students
    public void addStudent(Student s) { students.add(s); }
    public void viewStudents() {
        System.out.println("\n--- Student List ---");
        students.forEach(System.out::println);
    }

    //Manage Landlords
    public void addLandlord(Landlord l) { landlords.add(l); }
    public void viewLandlords() {
        System.out.println("\n--- Landlord List ---");
        landlords.forEach(System.out::println);
    }

    //Manage Houses
    public void addHouse(House h) { houses.add(h); }
    public void viewHouses() {
        System.out.println("\n--- House List ---");
        houses.forEach(System.out::println);
    }

    // Ties the student, housee, contract, and payment together
    public void createRentalAgreement(Student student, House house, String startDate, String endDate) {
        if (house.isAvailable()) {
            //Create Contract
            Contract newContract = new Contract(student.getName(), startDate, endDate, house.getRentPrice(), "Active");
            contracts.add(newContract);

            //Mark House as unavailable
            house.setAvailable(false);

            //Generate Payment
            Payment initialPayment = new Payment(newContract, house.getRentPrice(), "Paid");
            payments.add(initialPayment);

            System.out.println("Success: Rental processed for " + student.getName());
        } else {
            System.out.println("Error: House at " + house.getAddress() + " is already occupied!");
        }
    }

    public void viewAllPayments() {
        System.out.println("\n--- Transaction History ---");
        payments.forEach(System.out::println);
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
    public String getPassword() {
        return password;
    }
    private void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty.");
            this.name = "Unknown Admin";
        }
    }
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.toLowerCase().endsWith(".com")) {
            this.email = email;
        } else {
            System.out.println("Error: Invalid email format for " + name);
            this.email = "invalid@email.com";
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8) {
            this.password = password;
        } else {
            System.out.println("Error: Password must be at least 8 characters long for " + name);
            this.password = "defaultPass123";
        }
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
    
}
