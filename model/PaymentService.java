package model;

import java.util.ArrayList;
import java.util.List;
public class PaymentService {
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

    public List<Payment> search(String keyword) {
        List<Payment> results = new ArrayList<>();
        for (Payment p : payments) {
            if (p.getPaymentStatus().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(p);
            }
        }
        return results;
    }

    public Payment findById(int id) {
        for (Payment p : payments) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
