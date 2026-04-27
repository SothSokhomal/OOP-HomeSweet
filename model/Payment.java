package model;

public class Payment {
    private static int idCounter = 1;
    private int id;
    private int contractId;
    private double amount;
    private String paymentStatus;

    public Payment(int contractId, double amount, String paymentStatus){
        this.id = idCounter++;
        this.setContractId(contractId);
        this.setAmount(amount);
        this.setPaymentStatus(paymentStatus);
    }

    private int getId() {
        return id;
    }

    public int getContractId() {
        return contractId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setContractId(int contractId) {
        if(contractId > 0){
            this.contractId = contractId;
        } else {
            this.contractId = 0;
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
               ", contractId=" + contractId + 
               ", amount=$" + amount + 
               ", paymentStatus=" + paymentStatus + "]";
    }
}