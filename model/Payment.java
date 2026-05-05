package model;

public class Payment implements Displayable, Payable {
    private static int idCounter = 1;
    private int id;
    private Contract contract;
    private double amount;
    private PaymentStatus paymentStatus;

    public Payment(Contract contract, double amount, String paymentStatusStr){
        this.id = idCounter++;
        this.contract = contract;
        this.amount = (amount>0) ? amount : 0.0;
        this.paymentStatus = (paymentStatusStr == null) ? PaymentStatus.UNPAID : PaymentStatus.fromString(paymentStatusStr);
    }

    public int getId() {return id; }
    public Contract getContract() {return contract;}
    public double getAmount() {return amount;}
    public String getPaymentStatus() {return paymentStatus.name();}

    public void setAmount(double amount) {
        if(amount > 0){
            this.amount = amount;
        } else {
            this.amount = 0.0;
        }
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if(paymentStatus != null){
            this.paymentStatus = paymentStatus;
        } else {
            this.paymentStatus = PaymentStatus.PENDING;
        }
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + 
               ", contract=" + (contract != null ? contract.getId() : "0") + 
               ", amount=$" + amount + 
               ", paymentStatus=" + paymentStatus.name() + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void processPayment(double amount) {
        if (amount >= this.amount) {
            this.paymentStatus = PaymentStatus.PAID;
            if (this.contract != null) {
                this.contract.updateStatus(OrderStatus.ACTIVE.name());
            }
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Insufficient payment amount.");
        }
    }

    @Override
    public boolean isPaid() {
        return this.paymentStatus == PaymentStatus.PAID;
    }
}
