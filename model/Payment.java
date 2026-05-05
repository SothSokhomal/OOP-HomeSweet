package model;

public class Payment {
    private static int idCounter = 1;
    private int id;
    private Contract contract;
    private double amount;
    private String paymentStatus;

    public Payment(Contract contract, double amount, String paymentStatus){
        this.id = idCounter++;
        this.contract = contract;
        this.amount = (amount>0) ? amount : 0.0;
        this.paymentStatus = (paymentStatus == null) ? PaymentStatus.UNPAID.name() : PaymentStatus.fromString(paymentStatus).name();
    }

    public int getId() {return id; }
    public Contract getContract() {return contract;}
    public double getAmount() {return amount;}
    public String getPaymentStatus() {return paymentStatus;}

    public void setAmount(double amount) {
        if(amount > 0){
            this.amount = amount;
        } else {
            this.amount = 0.0;
        }
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if(paymentStatus != null){
            this.paymentStatus = paymentStatus.name();
        } else {
            this.paymentStatus = PaymentStatus.PENDING.name();
        }
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + 
               ", contract=" + (contract != null ? contract.getId() : "0") + 
               ", amount=$" + amount + 
               ", paymentStatus=" + paymentStatus + "]";
    }
}
