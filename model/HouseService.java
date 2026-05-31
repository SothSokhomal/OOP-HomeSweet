package model;

import java.util.ArrayList;
import java.util.List;
public class HouseService {
    private List<House> houses = new ArrayList<>();

    public void addHouse(House h) {
        houses.add(h);
    }

    public List<House> getHouses() {
        return houses;
    }

    public void viewHouses() {
        System.out.println("\n--- House List ---");
        for (House h : houses) {
            h.displayInfo();
        }
    }

    //overloaded method for search
    public List<House> search(String keyword) { //search by keyword
        List<House> results = new ArrayList<>();
        for (House h : houses) {
            if (h.getAddress().toLowerCase().contains(keyword.toLowerCase()) ||
                h.getCity().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(h);
            }
        }
        return results;
    }

    public List<House> search(double minRent, double maxRent) { //search by price range
        List<House> results = new ArrayList<>();
        for (House h : houses) {
            if (h.getRentPrice() >= minRent && h.getRentPrice() <= maxRent)
                results.add(h);
        }
        return results;
    }

    public House findById(int id) {
        for (House h : houses) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }
}
