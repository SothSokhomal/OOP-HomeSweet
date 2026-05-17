package model;

public class Admin extends Person {
    private static int idCounter = 1;

    public Admin(String name, String email, String phone, String password) {
        super(idCounter++, name, email, phone, password); // fix hardcoded phone
    }

    // Verify a landlord
    public void verifyLandlord(Landlord landlord) {
        landlord.setActive(true);
        System.out.println("Admin verified landlord: " + landlord.getName());
    }

    // View all students
    public void viewAllStudents(StudentService studentService) {
        System.out.println("\n--- Admin viewing all students ---");
        studentService.viewStudents();
    }

    // View all landlords
    public void viewAllLandlords(LandlordService landlordService) {
        System.out.println("\n--- Admin viewing all landlords ---");
        landlordService.viewLandlords();
    }

    // View all houses
    public void viewAllHouses(HouseService houseService) {
        System.out.println("\n--- Admin viewing all houses ---");
        houseService.viewHouses();
    }

    // View all contracts
    public void viewAllContracts(ContractService contractService) {
        System.out.println("\n--- Admin viewing all contracts ---");
        contractService.viewContracts();
    }
}