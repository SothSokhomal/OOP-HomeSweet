package model;

public class AuthService {

    public static Person authenticate(String username, String password, AdminService adminService, StudentService studentService, LandlordService landlordService) {
        // Check Admins
        if (adminService != null) {
            Admin admin = adminService.findByUsername(username);
            if (admin != null && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        
        // Check Students
        if (studentService != null) {
            Student student = studentService.findByUsername(username);
            if (student != null && student.getPassword().equals(password)) {
                return student;
            }
        }
        
        // Check Landlords
        if (landlordService != null) {
            Landlord landlord = landlordService.findByUsername(username);
            if (landlord != null && landlord.getPassword().equals(password)) {
                return landlord;
            }
        }
        
        return null;
    }
}
