// package model;

// public class Payment {
//     private static int idCounter = 1;
//     private int id;
//     private int contractId;
//     private double amount;
//     private String paymentStatus;

//     public Payment(int contractId, double amount, String paymentStatus){
//         this.id = idCounter++;
//         this.setContractId(contractId);
//         this.setAmount(amount);
//         this.setPaymentStatus(paymentStatus);
//     }

//     private int getId() {
//         return id;
//     }

//     public int getContractId() {
//         return contractId;
//     }

//     public double getAmount() {
//         return amount;
//     }

//     public String getPaymentStatus() {
//         return paymentStatus;
//     }

//     private void setId(int id) {
//         this.id = id;
//     }

//     public void setContractId(int contractId) {
//         if(contractId > 0){
//             this.contractId = contractId;
//         } else {
//             this.contractId = 0;
//         }
//     }

//     public void setAmount(double amount) {
//         if(amount > 0){
//             this.amount = amount;
//         } else {
//             this.amount = 0.0;
//         }
//     }

//     public void setPaymentStatus(String paymentStatus) {
//         if(paymentStatus != null && 
//            (paymentStatus.equalsIgnoreCase("Paid") || paymentStatus.equalsIgnoreCase("Pending"))){
//             this.paymentStatus = paymentStatus;
//         } else {
//             this.paymentStatus = "Pending";
//         }
//     }

//     @Override
//     public String toString() {
//         return "Payment [id=" + id + 
//                ", contractId=" + contractId + 
//                ", amount=$" + amount + 
//                ", paymentStatus=" + paymentStatus + "]";
//     }
// }



// package model;

// public class Payment {
//     private static int idCounter = 1;
//     private int id;
//     private Contract contract; // Changed to Contract object
//     private double amount;
//     private String paymentStatus;

//     public Payment(Contract contract, double amount, String paymentStatus){
//         this.id = idCounter++;
//         this.setContract(contract);
//         this.setAmount(amount);
//         this.setPaymentStatus(paymentStatus);
//     }

//     public int getId() { return id; }

//     public Contract getContract() { return contract; }

//     private void setId(int id) { this.id = id; }

//     public void setContract(Contract contract) { this.contract = contract; }

//     public void setAmount(double amount) {
//         this.amount = (amount > 0) ? amount : 0.0;
//     }

//     public void setPaymentStatus(String paymentStatus) {
//         this.paymentStatus = (paymentStatus != null) ? paymentStatus : "Pending";
//     }

//     @Override
//     public String toString() {
//         return "Payment [id=" + id + ", ContractID=" + (contract != null ? contract.getId() : "0") + 
//                ", amount=$" + amount + ", status=" + paymentStatus + "]";
//     }
// }


package model;

public class Payment {
    private static int idCounter = 1;
    private int id;
    private Contract contract;
    private double amount;

    public Payment(Contract contract, double amount){
        this.id = idCounter++;
        this.contract = contract;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", ContractID=" + contract.getId() + ", amount=" + amount + "]";
    }
}