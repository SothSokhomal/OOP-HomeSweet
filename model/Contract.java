package model;

public class Contract {
    private static int idCounter = 1;
    private int id;
    private String clientName;
    private String startDate;
    private String endDate;
    private double contractValue;
    private String status;
    
    public Contract(String clientName, String startDate, String endDate, double contractValue, String status){
        this.id = idCounter++;
        this.setClientName(clientName);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setContractValue(contractValue);
        this.setStatus(status);
    }
    private int getContractId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }


    public String getStartDate() {
        return startDate;
    }


    public String getEndDate() {
        return endDate;
    }

    public double getContractValue() {
        return contractValue;
    }
    public String getStatus() {
        return status;
    }

    private void setContractId(int id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        if (clientName != null && !clientName.trim().isEmpty()) {
            this.clientName = clientName;
        } else {
            this.clientName = "Unknown Client";
        }
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setContractValue(double contractValue) {
        this.contractValue = contractValue;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Contract [contractId=" + id + ", clientName=" + clientName + ", startDate=" + startDate + ", endDate=" + endDate + ", contractValue=" + contractValue + ", status=" + status + "]";
    }

    
    
}
