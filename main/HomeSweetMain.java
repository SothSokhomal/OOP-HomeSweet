package main;

import java.util.Scanner;

import model.Admin;
import model.AdminService;
import model.AuthService;
import model.Contract;
import model.ContractService;
import model.House;
import model.HouseService;
import model.Landlord;
import model.LandlordService;
import model.PaymentService;
import model.Person;
import model.RentalService;
import model.Student;
import model.StudentService;

public class HomeSweetMain {
    private static Scanner scanner = new Scanner(System.in);
    private static AdminService adminService = new AdminService();
    private static StudentService studentService = new StudentService();
    private static LandlordService landlordService = new LandlordService();
    private static HouseService houseService = new HouseService();
    private static ContractService contractService = new ContractService();
    private static PaymentService paymentService = new PaymentService();
    private static RentalService rentalService = new RentalService();

    public static void main(String[] args) {
        seedData();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Welcome to HomeSweet ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerMenu();
                    break;
                case "2":
                    loginMenu();
                    break;
                case "3":
                    System.out.println("Thank you for using HomeSweet!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerMenu() {
        System.out.println("\n--- Register ---");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.println("3. Landlord");
        System.out.print("Select Role: ");
        String roleChoice = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        switch (roleChoice) {
            case "1":
                Admin admin = new Admin(name, username, email, phone, password);
                adminService.addAdmin(admin);
                System.out.println("Admin registered successfully.");
                break;
            case "2":
                System.out.print("Enter National ID: ");
                String studentNationalId = scanner.nextLine();
                Student student = new Student(name, username, email, phone, password, studentNationalId);
                studentService.addStudent(student);
                System.out.println("Student registered successfully.");
                break;
            case "3":
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter National ID: ");
                String landlordNationalId = scanner.nextLine();
                Landlord landlord = new Landlord(name, username, phone, email, address, password, landlordNationalId, false, true);
                landlordService.addLandlord(landlord);
                System.out.println("Landlord registered successfully.");
                break;
            default:
                System.out.println("Invalid role selected.");
        }
    }

    private static void loginMenu() {
        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Person user = AuthService.authenticate(username, password, adminService, studentService, landlordService);

        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getName());
            if (user instanceof Admin) {
                adminMenu((Admin) user);
            } else if (user instanceof Student) {
                studentMenu((Student) user);
            } else if (user instanceof Landlord) {
                landlordMenu((Landlord) user);
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void adminMenu(Admin admin) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. View All Students");
            System.out.println("2. View All Landlords");
            System.out.println("3. View All Houses");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    studentService.viewStudents();
                    break;
                case "2":
                    landlordService.viewLandlords();
                    break;
                case "3":
                    houseService.viewHouses();
                    break;
                case "4":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void studentMenu(Student student) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. View Available Houses");
            System.out.println("2. View My Contracts");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    houseService.viewHouses();
                    break;
                case "2":
                    student.viewContracts();
                    break;
                case "3":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void landlordMenu(Landlord landlord) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Landlord Menu ===");
            System.out.println("1. View My Properties");
            System.out.println("2. Add Property");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    landlord.LandlordViewProperties();
                    break;
                case "2":
                    System.out.print("Enter property address: ");
                    String addr = scanner.nextLine();
                    System.out.print("Enter property price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    House newHouse = new House(addr, landlord, true, "Unknown", price);
                    landlord.addProperty(newHouse);
                    houseService.addHouse(newHouse);
                    System.out.println("Property added.");
                    break;
                case "3":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void seedData() {
        // Seed some initial data for testing
        Admin a1 = new Admin("John Admin", "admin1", "admin@gmail.com", "0000000000", "adminpass!");
        adminService.addAdmin(a1);

        Landlord l1 = new Landlord("Elizabeth Landlord", "landlord1", "1234567890", "landlord@gmail.com", "Phnom Penh",
                "landlordpass123", "14327632891230", true, true);
        landlordService.addLandlord(l1);

        Student s1 = new Student("Jane Student", "student1", "student@gmail.com", "9876543210",
                "studentpass@1", "12345678901234");
        studentService.addStudent(s1);

        House h1 = new House("123 Main St", l1, true, "Phnom Penh", 500.00);
        House h2 = new House("456 Oak Ave", l1, true, "Phnom Penh", 600.00);
        
        l1.addProperty(h1);
        l1.addProperty(h2);
        houseService.addHouse(h1);
        houseService.addHouse(h2);
    }
}
