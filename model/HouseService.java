package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.Searchable;

public class HouseService implements Searchable<House> {
    private List<House> houses = new ArrayList<>();

    public void addHouse(House h) {
        houses.add(h);
    }

    public void viewHouses() {
        System.out.println("\n--- House List ---");
        for (House h : houses) {
            h.displayInfo();
        }
    }

    @Override
    public List<House> search(String keyword) {
        List<House> results = new ArrayList<>();
        for (House h : houses) {
            if (h.getAddress().toLowerCase().contains(keyword.toLowerCase()) ||
                h.getCity().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(h);
            }
        }
        return results;
    }

    @Override
    public House findById(int id) {
        for (House h : houses) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }
}
