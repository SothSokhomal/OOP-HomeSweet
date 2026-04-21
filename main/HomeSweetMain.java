package main;

import model.Admin;
import model.House;
import model.Landlord;
import model.Student;

public class HomeSweetMain {
    public static void main(String[] args) {
        
        Landlord l1 = new Landlord("Elizabeth", "123-456-7890", "abc123@gmail.com", "Phnom Penh");
        Landlord l2 = new Landlord("Rose", "123-456-7890", "abc123@gmail.com", "Phnom Penh");


        Admin a1 = new Admin("John Doe", "johndoe@gmail.com", "password123!"); 
        Admin a2 = new Admin("Jane jane", "janedoe@gmail.com", "password456!"); 

        Student s1 = new Student("Jane Smith", "janesmith@gmail.com", "987-654-3210", "studentpassword@", "Contract A", "1234567890123");
        Student s2 = new Student("Smith", "janesmith@gmail.com", "987-654-3210", "studentpassword@", "Contract A", "1234567890123");
    

        House h1 = new House("123 Main St", "Elizabeth", true, 500.00);
        House h2 = new House("456 Oak Ave", "Rose", false, 600.00);

        System.out.println(l1);
        System.out.println(l2);

        System.out.println(a1);
        System.out.println(a2);

        System.out.println(s1);
        System.out.println(s2);
        
        System.out.println(h1);
        System.out.println(h2);
    }
}