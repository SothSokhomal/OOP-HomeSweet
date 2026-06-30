package model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import interfaces.HouseFilter;

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
        houses.forEach(House::displayInfo);
    }

    public List<House> filterHouses(HouseFilter filter) {
        return houses.stream()
                .filter(filter::matches)   // method reference to the single abstract method
                .collect(Collectors.toList());
    }

    // ── Real-world named filters ────────────────────────────────────────────

    /** "Show me only houses I can actually move into." */
    public List<House> getAvailableHouses() {
        return filterHouses(house -> house.isAvailable());
    }

    /** "I want to live in [city]." */
    public List<House> getHousesByCity(String city) {
        return filterHouses(house -> house.getCity().equalsIgnoreCase(city));
    }

    /** "My monthly budget is $[budget]." */
    public List<House> getHousesWithinBudget(double budget) {
        return filterHouses(house -> house.getRentPrice() <= budget);
    }

    /**
     * Point 8 — factory method (the "Search button click handler" pattern):
     * Reads city and maxBudget from caller (e.g. text-field values) and
     * builds a HouseFilter lambda on the spot — no new class file needed.
     *
     * Usage:
     *   HouseFilter f = HouseService.buildSmartFilter("Phnom Penh", 500);
     *   List<House> results = houseService.filterHouses(f);
     */
    public static HouseFilter buildSmartFilter(String city, double maxBudget) {
        return house -> house.isAvailable()
                     && house.getCity().equalsIgnoreCase(city)
                     && house.getRentPrice() <= maxBudget;
    }

    // ── Overloaded keyword / price-range search (kept for Admin menu) ───────

    /** Search by address or city keyword. */
    public List<House> search(String keyword) {
        String lower = keyword.toLowerCase();
        return filterHouses(house -> house.getAddress().toLowerCase().contains(lower)
                                 || house.getCity().toLowerCase().contains(lower));
    }

    /** Search by price range. */
    public List<House> search(double minPrice, double maxPrice) {
        return filterHouses(house -> house.getRentPrice() >= minPrice
                                 && house.getRentPrice() <= maxPrice);
    }

    public House findById(int id) {
        return houses.stream()
                .filter(house -> house.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
