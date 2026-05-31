package main;

import java.util.Scanner;
import java.util.List;

import model.Admin;
import model.AdminService;
import model.AuthService;
import model.Contract;
import model.ContractService;
import model.House;
import model.HouseService;
import model.Landlord;
import model.LandlordService;
import model.Payment;
import model.PaymentService;
import model.PaymentStatus;
import model.Person;
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

    // ==================== REGISTER ====================

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
                System.out.println("Landlord registered successfully. Awaiting admin verification.");
                break;
            default:
                System.out.println("Invalid role selected.");
        }
    }

    // ==================== LOGIN ====================

    private static void loginMenu() {
        System.out.println("\n--- Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Person user = AuthService.authenticate(username, password, adminService, studentService, landlordService);

        if (user != null) {
            System.out.println("Login successful! Welcome, " + user.getName());
            user.performRole();
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

    // ==================== ADMIN MENU ====================

    private static void adminMenu(Admin admin) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1.  View All Students");
            System.out.println("2.  View All Landlords");
            System.out.println("3.  View All Houses");
            System.out.println("4.  View All Contracts");
            System.out.println("5.  View All Payments");
            System.out.println("6.  Verify a Landlord");
            System.out.println("7.  Search Student by Name");
            System.out.println("8.  Search House by Address/City");
            System.out.println("9.  Admin Summary");
            System.out.println("10. Logout");
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
                    contractService.viewContracts();
                    break;
                case "5":
                    paymentService.viewAllPayments();
                    break;
                case "6":
                    System.out.print("Enter Landlord ID to verify: ");
                    try {
                        int lid = Integer.parseInt(scanner.nextLine());
                        admin.verifyLandlord(lid, landlordService.getLandlords());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;
                case "7":
                    System.out.print("Enter student name to search: ");
                    String sKeyword = scanner.nextLine();
                    List<Student> foundStudents = studentService.search(sKeyword);
                    if (foundStudents.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : foundStudents) s.displayInfo();
                    }
                    break;
                case "8":
                    System.out.print("Enter address or city to search: ");
                    String hKeyword = scanner.nextLine();
                    List<House> foundHouses = houseService.search(hKeyword);
                    if (foundHouses.isEmpty()) {
                        System.out.println("No houses found.");
                    } else {
                        for (House h : foundHouses) h.displayInfo();
                    }
                    break;
                case "9":
                    admin.displayInfo();
                    break;
                case "10":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ==================== STUDENT MENU ====================

    private static void studentMenu(Student student) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. View Available Houses");
            System.out.println("2. Book a House");
            System.out.println("3. Pay Bill");
            System.out.println("4. View My Contracts");
            // Issue 2 fix: added option 5 to use houseService.search(double, double)
            System.out.println("5. Search Houses by Price Range");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    houseService.viewHouses();
                    break;
                case "2":
                    System.out.print("Enter House ID to book: ");
                    try {
                        int hid = Integer.parseInt(scanner.nextLine());
                        House house = houseService.findById(hid);
                        if (house == null) {
                            System.out.println("House not found.");
                            break;
                        }
                        if (!house.isAvailable()) {
                            System.out.println("Sorry, that house is not available.");
                            break;
                        }
                        System.out.print("Enter start date (YYYY-MM-DD): ");
                        String start = scanner.nextLine();
                        System.out.print("Enter end date (YYYY-MM-DD): ");
                        String end = scanner.nextLine();

                        student.bookHouse(house, start, end);

                        // Contract handles contract creation, payment, and linking
                        Contract contract = Contract.createContract(student, house, start, end);
                        Contract.processRental(student, house, contract, paymentService.getPayments());

                        // Save contract to contractService
                        contractService.addContract(contract);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    }
                    break;
                case "3":
                    System.out.print("Enter amount to pay: ");
                    try {
                        double amount = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter payment method (e.g. Cash, ABA, Bank Transfer): ");
                        String method = scanner.nextLine();
                        student.payBill(amount, method);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "4":
                    student.viewContracts();
                    break;
                // Issue 2 fix: calls houseService.search(double, double) — the overloaded version
                case "5":
                    System.out.print("Enter minimum rent: $");
                    try {
                        double min = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter maximum rent: $");
                        double max = Double.parseDouble(scanner.nextLine());
                        List<House> priceResults = houseService.search(min, max);
                        if (priceResults.isEmpty()) {
                            System.out.println("No houses found in that price range.");
                        } else {
                            for (House h : priceResults) h.displayInfo();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "6":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ==================== LANDLORD MENU ====================

    private static void landlordMenu(Landlord landlord) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Landlord Menu ===");
            System.out.println("1. View My Properties");
            System.out.println("2. Add Property");
            System.out.println("3. Generate General Report");
            System.out.println("4. Generate Monthly Report");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    landlord.viewProperties();
                    break;
                case "2":
                    System.out.print("Enter property address: ");
                    String addr = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter monthly rent price: ");
                    try {
                        double price = Double.parseDouble(scanner.nextLine());
                        House newHouse = new House(addr, landlord, true, city, price);
                        landlord.addProperty(newHouse);
                        houseService.addHouse(newHouse);
                        System.out.println("Property added successfully.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price.");
                    }
                    break;
                case "3":
                    landlord.generateReport();
                    break;
                case "4":
                    System.out.print("Enter month (e.g. January): ");
                    String month = scanner.nextLine();
                    landlord.generateReport(month);
                    break;
                case "5":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ==================== SEED DATA ====================

    private static void seedData() {
        Admin a1 = new Admin("John Admin", "admin1", "admin@gmail.com", "0000000000", "adminpass!");
        adminService.addAdmin(a1);

        Landlord l1 = new Landlord("Elizabeth Landlord", "landlord1", "1234567890", "landlord@gmail.com",
                "Phnom Penh", "landlordpass123", "14327632891230", true, true);
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

        // Link seed data into admin's own lists so admin.displayInfo() shows correct counts
        a1.addStudent(s1);
        a1.addLandlord(l1);
        a1.addHouse(h1);
        a1.addHouse(h2);

        // Create additional houses and students for seeding contracts/payments
        Student s2 = new Student("Bob Student", "student2", "bob@gmail.com", "9876543211", "studentpass@2", "11111111111111");
        Student s3 = new Student("Alice Student", "student3", "alice@gmail.com", "9876543212", "studentpass@3", "22222222222222");
        Student s4 = new Student("Charlie Student", "student4", "charlie@gmail.com", "9876543213", "studentpass@4", "33333333333333");
        studentService.addStudent(s2);
        studentService.addStudent(s3);
        studentService.addStudent(s4);
        a1.addStudent(s2);
        a1.addStudent(s3);
        a1.addStudent(s4);

        House h3 = new House("789 Pine Rd", l1, true, "Phnom Penh", 450.00);
        House h4 = new House("101 Maple Dr", l1, true, "Phnom Penh", 550.00);
        l1.addProperty(h3);
        l1.addProperty(h4);
        houseService.addHouse(h3);
        houseService.addHouse(h4);
        a1.addHouse(h3);
        a1.addHouse(h4);

        // 1. Process standard rental using processPayment() (default)
        Contract c1 = Contract.createContract(s1, h1, "2026-06-01", "2027-06-01");
        s1.setContract(c1);
        h1.markUnavailable();
        Payment p1 = new Payment(c1, h1.getRentPrice(), PaymentStatus.PENDING.name());
        p1.processPayment(); // default
        paymentService.addPayment(p1);
        contractService.addContract(c1);
        a1.addContract(c1);
        a1.addPayment(p1);

        // 2. Process rental using processPayment("ABA")
        Contract c2 = Contract.createContract(s2, h2, "2026-06-01", "2027-06-01");
        s2.setContract(c2);
        h2.markUnavailable();
        Payment p2 = new Payment(c2, h2.getRentPrice(), PaymentStatus.PENDING.name());
        p2.processPayment("ABA"); // student chose ABA
        paymentService.addPayment(p2);
        contractService.addContract(c2);
        a1.addContract(c2);
        a1.addPayment(p2);

        // 3. Process rental using processPayment("Cash")
        Contract c3 = Contract.createContract(s3, h3, "2026-06-01", "2027-06-01");
        s3.setContract(c3);
        h3.markUnavailable();
        Payment p3 = new Payment(c3, h3.getRentPrice(), PaymentStatus.PENDING.name());
        p3.processPayment("Cash"); // student paid cash
        paymentService.addPayment(p3);
        contractService.addContract(c3);
        a1.addContract(c3);
        a1.addPayment(p3);

        // 4. Process rental using processPayment("Bank Transfer")
        Contract c4 = Contract.createContract(s4, h4, "2026-06-01", "2027-06-01");
        s4.setContract(c4);
        h4.markUnavailable();
        Payment p4 = new Payment(c4, h4.getRentPrice(), PaymentStatus.PENDING.name());
        p4.processPayment("Bank Transfer");
        paymentService.addPayment(p4);
        contractService.addContract(c4);
        a1.addContract(c4);
        a1.addPayment(p4);
    }
}