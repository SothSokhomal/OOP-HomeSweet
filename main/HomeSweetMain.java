package main;

import model.Admin;
import model.House;
import model.Landlord;
import model.OrderStatus;
import model.Payment;
import model.RentalService;
import model.Student;
import model.Contract;

public class HomeSweetMain {
    public static void main(String[] args) {

        Admin a1 = new Admin("John Doe", "johndoe@gmail.com", "password123!"); 
        
        //Create Landlords
        Landlord l1 = new Landlord("Elizabeth", "1234567890", "abc123@gmail.com", "Phnom Penh", "welkimoon123456", "1432763289123083", true, true);
        
        //Create Students (Passing 'null' for the Contract object initially)
        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "9876543210", "studentpassword@", null, "12345678901234");

        //Create Houses
        House h1 = new House("123 Main St", l1, true, "Phnom Penh", 500.00);
        House h2 = new House("456 Oak Ave", l1, true, "Phnom Penh", 600.00);

        // Store houses in Landlord lists
        l1.addHouse(h1);
        l1.addHouse(h2);

        //Register data into Admin's system
        a1.addLandlord(l1);
        a1.addStudent(s1);
        a1.addHouse(h1);
        a1.addHouse(h2);

        System.out.println("--- INITIAL STATE ---");
        a1.viewHouses();
        a1.viewStudents();
        a1.viewLandlords();

        System.out.println("\n--- PROCESSING RENTAL ---");
        RentalService service = new RentalService();
        Contract c1 = service.createContract(s1, h1, "2023-10-01", "2024-10-01");
        a1.addContract(c1);
        if (c1 == null) {
            System.err.println("Cannot create payment due to contract creation failure.");
        }else {
            service.processRental(s1, h1, c1, a1.getPayments());
        }

        System.out.println("\n--- UPDATED STATE ---");
        a1.viewHouses(); 
        a1.viewContracts();
        a1.viewAllPayments(); 
        
        // Landlord adds their properties
        l1.addProperty(h1);

        System.out.println("\n--- LANDLORD PROPERTIES ---");
        l1.LandlordViewProperties();
    }
}