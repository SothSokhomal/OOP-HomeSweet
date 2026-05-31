package model;

import interfaces.Displayable;
import interfaces.Payable;
import interfaces.StatusManageable;

public class Payment implements Displayable, Payable, StatusManageable {
    private static int nextPaymentId = 1;
    private int id;
    private Contract contract;
    private double amount;
    private PaymentStatus paymentStatus;
    private String paymentMethod;

    private static int paymentCount = 0;

    public Payment(Contract contract, double amount, String paymentStatusStr) {
        this.id = nextPaymentId++;
        this.contract = contract;
        setAmount(amount);
        this.paymentStatus = (paymentStatusStr == null) ? PaymentStatus.PENDING
                : PaymentStatus.fromString(paymentStatusStr);
        this.paymentMethod = "Default";
        paymentCount++;
    }

    public int getId() {
        return id;
    }

    public Contract getContract() {
        return contract;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus.name();
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            this.amount = 0.0;
        }
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if (paymentStatus != null) {
            this.paymentStatus = paymentStatus;
        } else {
            this.paymentStatus = PaymentStatus.PENDING;
        }
    }

    @Override
    public boolean processPayment() {
        if (contract == null) {
            System.out.println("Payment failed: No contract connected.");
            this.paymentStatus = PaymentStatus.FAILED;
            return false;
        }

        if (amount <= 0) {
            System.out.println("Payment failed: Amount must be greater than 0.");
            this.paymentStatus = PaymentStatus.FAILED;
            return false;
        }

        if (contract.getContractStatus() == ContractStatus.CANCELLED ||
            contract.getContractStatus() == ContractStatus.EXPIRED) {
            System.out.println("Payment failed: Contract is cancelled or expired.");
            this.paymentStatus = PaymentStatus.FAILED;
            return false;
        }

        if (amount < contract.getContractValue()) {
            System.out.println("Payment failed: Amount is less than contract value.");
            this.paymentStatus = PaymentStatus.FAILED;
            return false;
        }

        this.paymentStatus = PaymentStatus.PAID;
        contract.activateContract();
        System.out.println("Payment " + id + " processed successfully.");
        return true;
    }

    //overloaded method for processPayment
    public boolean processPayment(String paymentMethod) {
        if (paymentMethod != null && !paymentMethod.trim().isEmpty()) {
            this.paymentMethod = paymentMethod.trim();
        } else {
            this.paymentMethod = "Default";
        }
        return processPayment(); // delegates all validation logic to base method
    }

    public boolean isPaid() {
        return this.paymentStatus == PaymentStatus.PAID;
    }

    public static int getPaymentCount() {
        return paymentCount;
    }

    @Override
    public String getStatusText() {
        return paymentStatus.name();
    }

    @Override
    public void displayStatus() {
        System.out.println("Payment Status: " + paymentStatus.name());
    }

    @Override
    public void displayInfo() {
        System.out.println("Payment ID   : " + id);
        System.out.println("Amount       : $" + amount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Status       : " + paymentStatus.name());
        if (contract != null) {
            System.out.println("Contract ID  : " + contract.getId());
            if (contract.getStudent() != null)
                System.out.println("Student      : " + contract.getStudent().getName());
            if (contract.getHouse() != null)
                System.out.println("House        : " + contract.getHouse().getAddress());
        } else {
            System.out.println("Contract     : No contract connected");
        }
    }

    @Override
    public String toString() {
        return "Payment [id=" + id +
                ", contract=" + (contract != null ? contract.getId() : "0") +
                ", amount=$" + amount +
                ", paymentMethod=" + paymentMethod +
                ", paymentStatus=" + paymentStatus.name() + "]";
    }
}
