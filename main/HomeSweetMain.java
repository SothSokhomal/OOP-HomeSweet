package main;

import model.Admin;
import model.House;
import model.Landlord;
import model.Student;

public class HomeSweetMain {
    public static void main(String[] args) {

        Admin a1 = new Admin("John Doe", "johndoe@gmail.com", "password123!"); 
        
        //Create Landlords
<<<<<<< HEAD
        Landlord l1 = new Landlord("Elizabeth", "1234567890", "abc123@gmail.com", "Phnom Penh", "welkimoon123456", "1432763289123083", true, true);
        Landlord l2 = new Landlord("Rose", "1234567890", "rose@gmail.com", "Phnom Penh", "rosepassword", "1432763289123084", true, true);

        //Create Students
        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "987-654-3210", "studentpassword@", "Contract A", "1234567890123");
        Student s2 = new Student("Michael Brown", "michael@gmail.com", "987-654-3210", "studentpassword@", "Contract B", "1234567890124");
    
        //Create Houses (Pass the Landlord OBJECT, not a String)
        House h1 = new House("123 Main St", l1, true, "Phnom Penh", 500.00);
        House h2 = new House("456 Oak Ave", l2, true, "Phnom Penh", 600.00);
        House h3 = new House("789 Pine Rd", l1, true, "Phnom Penh", 550.00);
=======
        Landlord l1 = new Landlord("Elizabeth", "1234567890", "abc123@gmail.com", "Phnom Penh");

        //Create Students (Passing 'null' for the Contract object initially)
        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "9876543210", "studentpassword@", null, "12345678901234");

        //Create Houses
        House h1 = new House("123 Main St", l1, true, 500.00);
        House h2 = new House("456 Oak Ave", l1, true, 600.00);

        // Store houses in Landlord lists
        l1.addHouse(h1);
        l1.addHouse(h2);
>>>>>>> 9c6d07b34707d1d9a1bebf8b08307950f2e9e535

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
        a1.createRentalAgreement(s1, h1, "2023-10-01", "2024-10-01");

        System.out.println("\n--- UPDATED STATE ---");
        a1.viewHouses(); 
        a1.viewContracts();
        a1.viewAllPayments(); 
<<<<<<< HEAD
        
        // Landlord adds their properties
        l1.addProperty(h3);

        System.out.println("\n--- LANDLORD PROPERTIES ---");
        l1.LandlordViewProperties();
=======
>>>>>>> 9c6d07b34707d1d9a1bebf8b08307950f2e9e535
    }
}