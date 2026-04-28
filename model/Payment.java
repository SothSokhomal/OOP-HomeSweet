package model;

public class Payment {
    private static int idCounter = 1;
    private int id;
    private Contract contract;
    private double amount;
    private String paymentStatus;

    public Payment(Contract contract, double amount, String paymentStatus){
        this.id = idCounter++;
        this.setContract(contract);
        this.setAmount(amount);
        this.setPaymentStatus(paymentStatus);
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
        return paymentStatus;
    }

    //the id is auto generated, so we don't want to allow setting it from outside the class
    // private void setId(int id) {
    //     this.id = id;
    // }

    public void setContract(Contract contract) {
        if(contract != null){
            this.contract = contract;
        } else {
            this.contract = null;
        }
    }

    public void setAmount(double amount) {
        if(amount > 0){
            this.amount = amount;
        } else {
            this.amount = 0.0;
        }
    }

    public void setPaymentStatus(String paymentStatus) {
        if(paymentStatus != null && 
           (paymentStatus.equalsIgnoreCase("Paid") || paymentStatus.equalsIgnoreCase("Pending"))){
            this.paymentStatus = paymentStatus;
        } else {
            this.paymentStatus = "Pending";
        }
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + 
               ", contract=" + contract + 
               ", amount=$" + amount + 
               ", paymentStatus=" + paymentStatus + "]";
    }
}