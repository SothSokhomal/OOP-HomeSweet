package model;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private List<Admin> admins = new ArrayList<>();

    public void addAdmin(Admin a) {
        admins.add(a);
    }

    public void viewAdmins() {
        System.out.println("\n--- Admin List ---");
        for (Admin a : admins) {
            a.displayInfo();
        }
    }

    public Admin findById(int id) {
        for (Admin a : admins) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    
    public Admin findByUsername(String username) {
        for (Admin a : admins) {
            if (a.getUsername().equals(username)) {
                return a;
            }
        }
        return null;
    }
}
