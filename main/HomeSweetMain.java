package main;

import model.Admin;
import model.House;
import model.Landlord;
import model.RentalService;
import model.Student;
import model.Contract;
import model.StudentService;
import model.LandlordService;
import model.HouseService;
import model.ContractService;
import model.PaymentService;

public class HomeSweetMain {
    public static void main(String[] args) {
        // Create Admin
        Admin a1 = new Admin("John Doe", "johndoe@gmail.com", "0000000000", "password123!");

        // Create Landlord
        Landlord l1 = new Landlord("Elizabeth", "1234567890", "abc123@gmail.com", "Phnom Penh",
                "welkimoon123456", "14327632891230", true, true);

        // Create Student
        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "9876543210",
                "studentpassword@", "12345678901234");

        // Create Houses
        House h1 = new House("123 Main St", l1, true, "Phnom Penh", 500.00);
        House h2 = new House("456 Oak Ave", l1, true, "Phnom Penh", 600.00);
        House h3 = new House("789 Pine Rd", l1, true, "Phnom Penh", 550.00);

        // Register houses in Landlord
        l1.addHouse(h1);
        l1.addHouse(h2);
        l1.addHouse(h3);

        // Create Services
        StudentService studentService = new StudentService();
        LandlordService landlordService = new LandlordService();
        HouseService houseService = new HouseService();
        ContractService contractService = new ContractService();
        PaymentService paymentService = new PaymentService();

        // Register data into Services
        landlordService.addLandlord(l1);
        studentService.addStudent(s1);
        houseService.addHouse(h1);
        houseService.addHouse(h2);
        houseService.addHouse(h3);

        System.out.println("--- INITIAL STATE ---");
        houseService.viewHouses();
        studentService.viewStudents();
        landlordService.viewLandlords();

        System.out.println("\n--- PROCESSING RENTAL ---");
        RentalService service = new RentalService();
        Contract c1 = service.createContract(s1, h1, "2023-10-01", "2024-10-01");

        contractService.addContract(c1);
        if (c1 == null) {
            System.err.println("Cannot create payment due to contract creation failure.");
        } else {
            service.processRental(s1, h1, c1, paymentService.getPayments());
        }

        System.out.println("\n--- UPDATED STATE ---");
        houseService.viewHouses();
        contractService.viewContracts();
        paymentService.viewAllPayments();

        // Classes displaying their own related data
        System.out.println("\n--- CLASSES DISPLAYING THEIR OWN RELATED DATA ---");
        s1.viewContracts();
        l1.LandlordViewProperties();
        c1.viewDetails();

        // Admin actions
        a1.verifyLandlord(l1);

        // Add objects to Admin to manage
        a1.addStudent(s1);
        a1.addLandlord(l1);
        a1.addHouse(h1);
        a1.addHouse(h2);
        a1.addHouse(h3);
        a1.addContract(c1);
        for (model.Payment p : paymentService.getPayments()) {
            a1.addPayment(p);
        }

        a1.displayAllStudents();
        a1.displayAllLandlords();
        a1.displayAllHouses();
        a1.displayAllContracts();
        a1.displayAllPayments();

        // Search demo
        System.out.println("\n--- SEARCH DEMO ---");
        Student found = a1.findStudentById(s1.getId());
        System.out.println("findStudentById(" + s1.getId() + "): " + (found != null ? found.getName() : "Not found"));
        House foundHouse = a1.findHouseById(h1.getId());
        System.out.println("findHouseById(" + h1.getId() + "): " + (foundHouse != null ? foundHouse.getAddress() : "Not found"));

        a1.displayInfo();

        // Static counters
        System.out.println("\n--- OBJECT COUNTERS ---");
        System.out.println("Total Students : " + Student.getStudentCount());
        System.out.println("Total Landlords: " + Landlord.getLandlordCount());
        System.out.println("Total Houses   : " + House.getHouseCount());
        System.out.println("Total Contracts: " + Contract.getContractCount());
        System.out.println("Total Payments : " + model.Payment.getPaymentCount());
    }
}
