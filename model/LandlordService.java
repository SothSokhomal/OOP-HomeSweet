package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.Searchable;

public class LandlordService implements Searchable<Landlord> {
    private List<Landlord> landlords = new ArrayList<>();

    public void addLandlord(Landlord l) {
        landlords.add(l);
    }

    public void viewLandlords() {
        System.out.println("\n--- Landlord List ---");
        for (Landlord l : landlords) {
            l.displayInfo();
        }
    }

    @Override
    public List<Landlord> search(String keyword) {
        List<Landlord> results = new ArrayList<>();
        for (Landlord l : landlords) {
            if (l.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(l);
            }
        }
        return results;
    }

    @Override
    public Landlord findById(int id) {
        for (Landlord l : landlords) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
}
