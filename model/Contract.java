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
    public int getContractId() {
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
        if (startDate != null && !startDate.isEmpty()) {
            this.startDate = startDate;
        } else {
            System.out.println("Invalid start date");
        }
    }

    public void setEndDate(String endDate) {
        if (endDate != null && !endDate.isEmpty()) {
            this.endDate = endDate;
        } else {
            System.out.println("Invalid end date");
        }
    }

    public void setContractValue(double contractValue) {
        if (contractValue > 0) {
            this.contractValue = contractValue;
        } else {
            System.out.println("Invalid contract value");
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        } else {
            this.status = "Unknown Status";
        }
    }


    @Override
    public String toString() {
        return "Contract [contractId=" + id + ", clientName=" + clientName + ", startDate=" + startDate + ", endDate=" + endDate + ", contractValue=" + contractValue + ", status=" + status + "]";
    }

    
    
}
