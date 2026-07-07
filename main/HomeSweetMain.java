package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import interfaces.HouseFilter;

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
import model.Person;
import model.Student;
import model.StudentService;
import model.RentalService;
import interfaces.Displayable;
import interfaces.StatusManageable;

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
        demonstratePolymorphism();
        demonstrateDesignChoice();   // Point 9 — runs on startup
        boolean running = true;

        while (running) {
            System.out.println("\n=== Welcome to HomeSweet ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Run Week 8 Polymorphism Tests");
            System.out.println("4. Exit");
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
                    testPolymorphism();
                    break;
                case "4":
                    System.out.println("Thank you for using HomeSweet!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // ==================== POLYMORPHISM DEMO ====================

    /**
     * Demonstrates runtime polymorphism:
     * A List<Person> holds Admin, Landlord, and Student objects.
     * Calling performRole() on each Person invokes the correct
     * overridden implementation at runtime.
     */
    private static void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println("   Polymorphism Demo - performRole()");
        System.out.println("========================================");

        // Create a List of Person (polymorphic reference type)
        List<Person> persons = new ArrayList<>();

        // Add an Admin object to the list
        Admin admin = new Admin("Alice Admin", "aliceadmin", "alice@gmail.com", "0123456789", "alice@Pass1");
        persons.add(admin);

        // Add a Landlord object to the list
        Landlord landlord = new Landlord("Bob Landlord", "boblandlord", "0987654321", "bob@gmail.com",
                "Siem Reap", "bob@Pass123", "12345678901234", true, true);
        persons.add(landlord);

        // Add a Student object to the list
        Student student = new Student("Charlie Student", "charliestudent", "charlie@gmail.com",
                "0111222333", "charlie@Pass1", "98765432109876");
        persons.add(student);

        // For each Person in the list, call performRole()
        // Each subclass's overridden performRole() is called at runtime
        for (Person person : persons) {
            System.out.println("[" + person.getClass().getSimpleName() + "] " + person.getName() + ":");
            // person.performRole(); // Removed because performRole is now interactive
            System.out.println("Role logic is now interactive via menus.");
            System.out.println();
        }

        System.out.println("========================================\n");
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
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    // ==================== ADMIN MENU ====================

    public static void adminMenu(Admin admin) {
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

    public static void studentMenu(Student student) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. View All Houses");
            System.out.println("2. Book a House");
            System.out.println("3. Pay Bill");
            System.out.println("4. View My Contracts");
            System.out.println("5. Search Houses by Price Range");
            System.out.println("6. Advanced House Search");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Lambda filter: only houses that are still available
                    HouseFilter availableOnly = house -> house.isAvailable();
                    List<House> availableHouses = houseService.filterHouses(availableOnly);
                    System.out.println("\n--- Available Houses ---");
                    if (availableHouses.isEmpty()) {
                        System.out.println("No houses are currently available.");
                    } else {
                        availableHouses.forEach(House::displayInfo);
                    }
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

                        // RentalService handles contract creation, payment, and linking
                        Contract contract = Contract.createContract(student, house, start, end);
                        rentalService.processRental(student, house, contract, paymentService.getPayments());

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
                    advancedHouseSearch();
                    break;
                case "7":
                    System.out.println("Logging out...");
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ==================== ADVANCED HOUSE SEARCH ====================

    private static void advancedHouseSearch() {
        System.out.println("\n=== Advanced House Search ===");
        System.out.println("1. Show only available houses");
        System.out.println("2. Search by city");
        System.out.println("3. Search within my budget");
        System.out.println("4. Available in my city, within my budget  (smart search)");
        System.out.print("Choose a filter: ");
        String pick = scanner.nextLine();

        List<House> results;

        switch (pick) {
            case "1":
                results = houseService.getAvailableHouses();
                printFilterResults(results, "Available Houses");
                break;

            case "2":
                System.out.print("Enter city (e.g. Phnom Penh, Siem Reap): ");
                String city = scanner.nextLine();
                results = houseService.getHousesByCity(city);
                printFilterResults(results, "Houses in " + city);
                break;

            case "3":
                System.out.print("Enter your monthly budget: $");
                try {
                    double budget = Double.parseDouble(scanner.nextLine());
                    results = houseService.getHousesWithinBudget(budget);
                    printFilterResults(results, "Houses at or under $" + budget);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount.");
                }
                break;

            case "4":
                System.out.print("Enter your city: ");
                String targetCity = scanner.nextLine();
                System.out.print("Enter your monthly budget: $");
                try {
                    double maxRent = Double.parseDouble(scanner.nextLine());

                    // ── Point 4: Anonymous class form ─────────────────────────────
                    HouseFilter smartAnon = new HouseFilter() {
                        @Override
                        public boolean matches(House house) {
                            return house.isAvailable()
                                && house.getCity().equalsIgnoreCase(targetCity)
                                && house.getRentPrice() <= maxRent;
                        }
                    };

                    // ── Point 5 & 6: Lambda form — variable name 'house', one line ─
                    HouseFilter smartLambda = house -> house.isAvailable()
                            && house.getCity().equalsIgnoreCase(targetCity)
                            && house.getRentPrice() <= maxRent;

                    // ── Point 8: Factory method form — built from user input ────────
                    // buildSmartFilter() acts as the "Search button click handler":
                    // it takes the values the user typed and returns a ready HouseFilter.
                    HouseFilter smartFactory = HouseService.buildSmartFilter(targetCity, maxRent);

                    // ── Point 7: All three produce identical output ────────────────
                    System.out.println("\n[Anonymous class result]");
                    printFilterResults(houseService.filterHouses(smartAnon),
                            "Available in " + targetCity + " at or under $" + maxRent);

                    System.out.println("\n[Lambda result]");
                    printFilterResults(houseService.filterHouses(smartLambda),
                            "Available in " + targetCity + " at or under $" + maxRent);

                    System.out.println("\n[Factory method result (Point 8 — buildSmartFilter)]");
                    printFilterResults(houseService.filterHouses(smartFactory),
                            "Available in " + targetCity + " at or under $" + maxRent);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount.");
                }
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    /** Prints a labelled list of houses, or a not-found message. */
    private static void printFilterResults(List<House> results, String label) {
        System.out.println("\n--- " + label + " ---");
        if (results.isEmpty()) {
            System.out.println("No houses matched your search.");
        } else {
            results.forEach(House::displayInfo);
        }
    }

    // ==================== POINT 9: DESIGN CHOICE DEMO ====================

    /**
     * Point 9 — runs at startup and shows WHY HouseFilter suits a lambda
     * while House must stay a full class, by actually creating both and
     * printing their observable characteristics.
     */
    private static void demonstrateDesignChoice() {
        System.out.println("\n========================================");
        System.out.println("   Point 9: Lambda vs Full Class Design");
        System.out.println("========================================");

        // HouseFilter: one rule, no fields, no state — defined as a lambda
        HouseFilter availableAndCheap = house -> house.isAvailable()
                                               && house.getRentPrice() <= 300;
        System.out.println("[HouseFilter as lambda]");
        System.out.println("  Rule: available AND rent <= $300");
        System.out.println("  Implementation: single line, no class file needed");
        System.out.println();

        // House: multiple fields, validation, two interfaces — must be a full class
        Landlord demoLandlord = new Landlord(
                "Demo Owner", "demoowner", "0100000000", "demo@gmail.com",
                "Demo Address", "demopass@1", "10000000000000", true, true);
        House demoHouse = new House("42 Lambda St", demoLandlord, true, "Phnom Penh", 250.0);

        System.out.println("[House as full class]");
        System.out.println("  Fields   : id, address, city, rentPrice, landlord, isAvailable");
        System.out.println("  Validation: rentPrice must be > 0 (throws IllegalArgumentException)");
        System.out.println("  Interface : Displayable  -> displayInfo()");
        demoHouse.displayInfo();
        System.out.println("  Interface : StatusManageable  -> displayStatus()");
        demoHouse.displayStatus();
        System.out.println();

        // Prove the lambda works on the House object
        System.out.println("[HouseFilter lambda applied to the House above]");
        System.out.println("  matches(demoHouse) = " + availableAndCheap.matches(demoHouse));

        System.out.println("========================================\n");
    }

    // ==================== LANDLORD MENU ====================

    public static void landlordMenu(Landlord landlord) {
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
                "Phnom Penh", "landlordpass123!", "14327632891230", true, true);
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

        // 1. Process standard rental using RentalService
        Contract c1 = Contract.createContract(s1, h1, "2026-06-01", "2027-06-01");
        rentalService.processRental(s1, h1, c1, paymentService.getPayments());
        contractService.addContract(c1);
        a1.addContract(c1);
        a1.addPayment(paymentService.getPayments().get(paymentService.getPayments().size() - 1));

        // 2. Process rental using processPayment("ABA")
        Contract c2 = Contract.createContract(s2, h2, "2026-06-01", "2027-06-01");
        rentalService.processRental(s2, h2, c2, paymentService.getPayments(), "ABA");
        contractService.addContract(c2);
        a1.addContract(c2);
        a1.addPayment(paymentService.getPayments().get(paymentService.getPayments().size() - 1));

        // 3. Process rental using processPayment("Cash")
        Contract c3 = Contract.createContract(s3, h3, "2026-06-01", "2027-06-01");
        rentalService.processRental(s3, h3, c3, paymentService.getPayments(), "Cash");
        contractService.addContract(c3);
        a1.addContract(c3);
        a1.addPayment(paymentService.getPayments().get(paymentService.getPayments().size() - 1));

        // 4. Process rental using processPayment("Bank Transfer")
        Contract c4 = Contract.createContract(s4, h4, "2026-06-01", "2027-06-01");
        rentalService.processRental(s4, h4, c4, paymentService.getPayments(), "Bank Transfer");
        contractService.addContract(c4);
        a1.addContract(c4);
        a1.addPayment(paymentService.getPayments().get(paymentService.getPayments().size() - 1));
    }

    private static void testPolymorphism() {
        System.out.println("\n========== Week 8 Polymorphism Test ==========");

        // Task 1: Subclass/Superclass Polymorphism with Person
        System.out.println("\n--- Task 1: Subclass/Superclass Polymorphism (Person) ---");
        java.util.ArrayList<Person> users = new java.util.ArrayList<>();
        Student testStudent = new Student("Dara", "dara01", "dara@gmail.com", "0123456789", "Pass@123", "12345678901234");
        Landlord testLandlord = new Landlord("Sokha", "sokha01", "0112233445", "sokha@gmail.com", "Phnom Penh", "landpass@123", "14327632891234", true, true);
        Admin testAdmin = new Admin("Admin", "admin01", "admin@gmail.com", "0987654321", "adminpass@123");

        users.add(testStudent);
        users.add(testLandlord);
        users.add(testAdmin);

        for (Person user : users) {
            user.displayInfo();
            // user.performRole(); // Removed because performRole is now interactive
            System.out.println("----------------------------------------------");
        }

        // Task 2: Interface Polymorphism with Displayable
        System.out.println("\n--- Task 2: Interface Polymorphism (Displayable) ---");
        java.util.ArrayList<Displayable> displayItems = new java.util.ArrayList<>();

        // Create some sample house, contract, and payment for demonstration
        House testHouse = new House("789 Test Rd", testLandlord, true, "Siem Reap", 400.0);
        Contract testContract = Contract.createContract(testStudent, testHouse, "2026-07-01", "2027-07-01");
        Payment testPayment = new Payment(testContract, 400.0, "PENDING");

        displayItems.add(testStudent);
        displayItems.add(testLandlord);
        displayItems.add(testAdmin);
        displayItems.add(testHouse);
        displayItems.add(testContract);
        displayItems.add(testPayment);

        for (Displayable item : displayItems) {
            item.displayInfo();
            System.out.println("----------------------------------------------");
        }

        // Task 3: Interface Polymorphism with StatusManageable
        System.out.println("\n--- Task 3: Interface Polymorphism (StatusManageable) ---");
        java.util.ArrayList<StatusManageable> statusItems = new java.util.ArrayList<>();

        statusItems.add(testHouse);
        statusItems.add(testContract);
        statusItems.add(testPayment);

        for (StatusManageable item : statusItems) {
            item.displayStatus();
            System.out.println("----------------------------------------------");
        }
    }
}