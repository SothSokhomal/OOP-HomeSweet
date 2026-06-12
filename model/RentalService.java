package model;

import java.util.List;

public class RentalService {
    
    /**
     * Centralized logic to process a rental transaction.
     * Links the contract to the student, marks the house as unavailable,
     * creates and processes the default payment, and updates the payment list.
     */
    public void processRental(Student student, House house, Contract contract, List<Payment> payments) {
        if (house.isAvailable()) {
            student.setContract(contract);
            house.markUnavailable();

            Payment payment = new Payment(contract, house.getRentPrice(), PaymentStatus.PENDING.name());
            payment.processPayment(); // Process payment immediately — activates contract
            payments.add(payment);

            System.out.println("Rental Processed for: " + student.getName() + ", at house: " + house.getAddress());
        } else {
            System.out.println("House is NOT available!");
        }
    }

    /**
     * Overloaded method to process a rental transaction using a specific payment method.
     */
    public void processRental(Student student, House house, Contract contract, List<Payment> payments, String paymentMethod) {
        if (house.isAvailable()) {
            student.setContract(contract);
            house.markUnavailable();

            Payment payment = new Payment(contract, house.getRentPrice(), PaymentStatus.PENDING.name());
            if (paymentMethod != null && !paymentMethod.trim().isEmpty() && !paymentMethod.equalsIgnoreCase("Default")) {
                payment.processPayment(paymentMethod);
            } else {
                payment.processPayment();
            }
            payments.add(payment);

            System.out.println("Rental Processed for: " + student.getName() + ", at house: " + house.getAddress());
        } else {
            System.out.println("House is NOT available!");
        }
    }
}
