package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.Searchable;

public class PaymentService implements Searchable<Payment> {
    private List<Payment> payments = new ArrayList<>();

    public void addPayment(Payment p) {
        payments.add(p);
    }
    
    public List<Payment> getPayments() {
        return payments;
    }

    public void viewAllPayments() {
        System.out.println("\n--- Payment History ---");
        for (Payment p : payments) {
            p.displayInfo();
        }
    }

    @Override
    public List<Payment> search(String keyword) {
        List<Payment> results = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getPaymentStatus().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(p);
            }
        }
        return results;
    }

    @Override
    public Payment findById(int id) {
        for (Payment p : payments) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
