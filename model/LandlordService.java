package model;

import java.util.ArrayList;
import java.util.List;
public class LandlordService {
    private List<Landlord> landlords = new ArrayList<>();

    public void addLandlord(Landlord l) {
        landlords.add(l);
    }

    public List<Landlord> getLandlords() {
        return landlords;
    }

    public void viewLandlords() {
        System.out.println("\n--- Landlord List ---");
        for (Landlord l : landlords) {
            l.displayInfo();
        }
    }

    public List<Landlord> search(String keyword) {
        List<Landlord> results = new ArrayList<>();
        for (Landlord l : landlords) {
            if (l.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(l);
            }
        }
        return results;
    }

    public Landlord findById(int id) {
        for (Landlord l : landlords) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    public Landlord findByUsername(String username) {
        for (Landlord l : landlords) {
            if (l.getUsername().equals(username)) {
                return l;
            }
        }
        return null;
    }
}
