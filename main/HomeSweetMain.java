package main;

import model.Admin;
import model.House;
import model.Landlord;
import model.Payment;
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
        //create Admin
        Admin a1 = new Admin("John Doe", "johndoe@gmail.com", "password123!");

        // Create Landlords
        Landlord l1 = new Landlord("Elizabeth", "1234567890", "abc123@gmail.com", "Phnom Penh", "welkimoon123456",
                "1432763289123083", true, true);

        // Create Students
        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "9876543210", "studentpassword@", null,
                "12345678901234");

        // Create Houses
        House h1 = new House("123 Main St", l1, true, "Phnom Penh", 500.00);
        House h2 = new House("456 Oak Ave", l1, true, "Phnom Penh", 600.00);
        House h3 = new House("789 Pine Rd", l1, true, "Phnom Penh", 550.00);

        // Store houses in Landlord lists
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

        // Landlord adds their properties
        l1.addProperty(h1);

        // classes displaying it's own related data
        System.out.println("\n--- CLASSES DISPLAYING THEIR OWN RELATED DATA ---");
        s1.viewContracts();
        l1.LandlordViewProperties();
        c1.viewDetails();
    }
}