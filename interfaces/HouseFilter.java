package interfaces;

import model.House;

/**
 * Functional interface representing a single house-search rule.
 *
 * In a real housing platform, students filter listings by different
 * criteria depending on what matters to them — location, budget, or
 * availability. HouseFilter captures one such rule as a lambda so that
 * any combination can be built on the fly without writing a new class.
 *
 * Real-world usage examples:
 *
 *   // "I only want houses that are still available"
 *   HouseFilter availableOnly = house -> house.isAvailable();
 *
 *   // "I need something in Phnom Penh"
 *   HouseFilter inPhnomPenh = house -> house.getCity().equalsIgnoreCase("Phnom Penh");
 *
 *   // "My monthly budget is $500"
 *   HouseFilter withinBudget = house -> house.getRentPrice() <= 500;
 *
 *   // "Available in Phnom Penh and within my $500 budget" — combined rule
 *   HouseFilter readyToRent = house -> house.isAvailable()
 *                                   && house.getCity().equalsIgnoreCase("Phnom Penh")
 *                                   && house.getRentPrice() <= 500;
 */
@FunctionalInterface
public interface HouseFilter {
    boolean matches(House house);
}
