package interfaces;

public interface Payable {
    void processPayment(double amount);

    boolean isPaid();
}
