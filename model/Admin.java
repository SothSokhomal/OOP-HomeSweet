package model;

import java.util.ArrayList;
import interfaces.Searchable;

public class Admin extends Person implements Searchable {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Landlord> landlords = new ArrayList<>();
    private ArrayList<House> houses = new ArrayList<>();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ArrayList<Payment> payments = new ArrayList<>();

    private static int adminCount = 0;

    public Admin(String name, String username, String email, String phone, String password) {
        super(name, username, email, phone, password);
        adminCount++;
    }

    public boolean addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean addLandlord(Landlord landlord) {
        if (landlord != null && !landlords.contains(landlord)) {
            landlords.add(landlord);
            return true;
        }
        return false;
    }

    public boolean addHouse(House house) {
        if (house != null && !houses.contains(house)) {
            houses.add(house);
            return true;
        }
        return false;
    }

    public boolean addContract(Contract contract) {
        if (contract != null && !contracts.contains(contract)) {
            contracts.add(contract);
            return true;
        }
        return false;
    }

    public boolean addPayment(Payment payment) {
        if (payment != null && !payments.contains(payment)) {
            payments.add(payment);
            return true;
        }
        return false;
    }

    @Override
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    @Override
    public Landlord findLandlordById(int id) {
        for (Landlord l : landlords) {
            if (l.getId() == id) return l;
        }
        return null;
    }

    @Override
    public House findHouseById(int id) {
        for (House h : houses) {
            if (h.getId() == id) return h;
        }
        return null;
    }

    @Override
    public Contract findContractById(int id) {
        for (Contract c : contracts) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    public Payment findPaymentById(int id) {
        for (Payment p : payments) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void verifyLandlord(Landlord landlord) {
        if (landlord != null) {
            landlord.setActive(true);
            landlord.setVerified(true);
            System.out.println("Admin verified landlord: " + landlord.getName());
        }
    }

    public void verifyLandlord(int landlordId, java.util.List<Landlord> allLandlords) {
        // First look in admin's own tracked list, then fall back to the full registry
        Landlord landlord = findLandlordById(landlordId);
        if (landlord == null && allLandlords != null) {
            for (Landlord l : allLandlords) {
                if (l.getId() == landlordId) {
                    landlord = l;
                    break;
                }
            }
        }
        if (landlord != null) {
            verifyLandlord(landlord);
        } else {
            System.out.println("Landlord with ID " + landlordId + " not found.");
        }
    }

    public void displayAllStudents() {
        System.out.println("\n========== Students ==========");
        if (students.isEmpty()) {
            System.out.println("No students registered.");
        } else {
            for (Student s : students) {
                s.displayInfo();
                System.out.println("------------------------------");
            }
        }
    }

    public void displayAllLandlords() {
        System.out.println("\n========== Landlords ==========");
        if (landlords.isEmpty()) {
            System.out.println("No landlords registered.");
        } else {
            for (Landlord l : landlords) {
                l.displayInfo();
                System.out.println("------------------------------");
            }
        }
    }

    public void displayAllHouses() {
        System.out.println("\n========== Houses ==========");
        if (houses.isEmpty()) {
            System.out.println("No houses registered.");
        } else {
            for (House h : houses) {
                h.displayInfo();
                System.out.println("------------------------------");
            }
        }
    }

    public void displayAllContracts() {
        System.out.println("\n========== Contracts ==========");
        if (contracts.isEmpty()) {
            System.out.println("No contracts registered.");
        } else {
            for (Contract c : contracts) {
                c.displayInfo();
                System.out.println("------------------------------");
            }
        }
    }

    public void displayAllPayments() {
        System.out.println("\n========== Payments ==========");
        if (payments.isEmpty()) {
            System.out.println("No payments registered.");
        } else {
            for (Payment p : payments) {
                p.displayInfo();
                System.out.println("------------------------------");
            }
        }
    }

    public static int getAdminCount() {
        return adminCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== Admin Summary ==========");
        super.displayInfo();
        System.out.println("Students     : " + students.size());
        System.out.println("Landlords    : " + landlords.size());
        System.out.println("Houses       : " + houses.size());
        System.out.println("Contracts    : " + contracts.size());
        System.out.println("Payments     : " + payments.size());
        System.out.println("===================================");
    }

    @Override
    public void performRole() {
        System.out.println("Admin " + getName() + " is managing the entire HomeSweet system.");
    }

    // Overloaded methods for manageRecord
    public void manageRecord(Student student) {
        System.out.println("Admin " + getName() + " is managing record for Student: " + student.getName());
    }

    public void manageRecord(Landlord landlord) {
        System.out.println("Admin " + getName() + " is managing record for Landlord: " + landlord.getName());
    }

    public void manageRecord(House house) {
        System.out.println("Admin " + getName() + " is managing record for House ID: " + house.getId());
    }

    public void manageRecord(Contract contract) {
        System.out.println("Admin " + getName() + " is managing record for Contract ID: " + contract.getId());
    }

    public void manageRecord(Payment payment) {
        System.out.println("Admin " + getName() + " is managing record for Payment ID: " + payment.getId());
    }
}
