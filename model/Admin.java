package model;
import java.util.ArrayList;

public class Admin {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Landlord> landlords = new ArrayList<>();
    private ArrayList<House> houses = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();

    public Admin(String name, String email, String password){
        this.name = name;
    }

    public void addStudent(Student s) { students.add(s); }
    public void addLandlord(Landlord l) { landlords.add(l); }
    public void addHouse(House h) { houses.add(h); }

    public void viewStudents() {
        System.out.println("\n--- Student List ---");
        for(Student s : students) System.out.println(s);
    }
    public void viewLandlords() {
        System.out.println("\n--- Landlord List ---");
        for(Landlord l : landlords) System.out.println(l);
    }
    public void viewHouses() {
        System.out.println("\n--- House List ---");
        for(House h : houses) System.out.println(h);
    }
    public void viewAllPayments() {
        System.out.println("\n--- Payment History ---");
        for(Payment p : payments) System.out.println(p);
    }

    public void createRentalAgreement(Student student, House house, String startDate, String endDate) {
        if (house.isAvailable()) {
            Contract c = new Contract(student.getName(), startDate, endDate, house.getRentPrice(), "Active", student, house);
            contracts.add(c);
            student.setContract(c); // Link the contract to the student
            house.setAvailable(false);
            payments.add(new Payment(c, house.getRentPrice()));
            System.out.println("Rental Processed for: " + student.getName());
        }
    }
}