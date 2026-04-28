package main;

import model.Admin;
import model.House;
import model.Landlord;
import model.Student;

public class HomeSweetMain {
    public static void main(String[] args) {

        Admin a1 = new Admin("John Doe", "johndoe@gmail.com", "password123!"); 
    
        Landlord l1 = new Landlord("Elizabeth", "123-456-7890", "abc123@gmail.com", "Phnom Penh");
        Landlord l2 = new Landlord("Rose", "123-456-7890", "rose@gmail.com", "Phnom Penh");

    
        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "987-654-3210", "studentpassword@", null, "1234567890123");
        Student s2 = new Student("Michael Brown", "michael@gmail.com", "987-654-3210", "studentpassword@", null, "1234567890124");
    
        House h1 = new House("123 Main St", l1, true, 500.00);
        House h2 = new House("456 Oak Ave", l2, true, 600.00);

        a1.addLandlord(l1);
        a1.addLandlord(l2);
        a1.addStudent(s1);
        a1.addStudent(s2);
        a1.addHouse(h1);
        a1.addHouse(h2);

        l1.addHouse(h1);
        l2.addHouse(h2);

        System.out.println("--- INITIAL STATE ---");
        a1.viewHouses();
        a1.viewStudents();
        a1.viewLandlords();

        System.out.println("\n--- PROCESSING RENTAL ---");
        a1.createRentalAgreement(s1, h1, "2023-10-01", "2024-10-01");
        a1.createRentalAgreement(s2, h2, "2023-11-01", "2024-11-01");

        System.out.println("\n--- UPDATED STATE ---");
        a1.viewHouses(); 
        a1.viewAllPayments(); 
    }
}