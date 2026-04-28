package model;

public class Contract {
    private static int idCounter = 1;
    private int id;
    private Student student;
    private House house;
    private String startDate;
    private String endDate;
    private double contractValue;
    private String status;
    private String clientName;

    public Contract(String clientName, String startDate, String endDate, double contractValue, String status, Student student, House house){
        this.id = idCounter++;
        this.setClientName(clientName);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setContractValue(contractValue);
        this.setStatus(status);
        this.setStudent(student); 
        this.setHouse(house);     
    }

    public int getId() {
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

    public Student getStudent() {
        return student;
    }

    public House getHouse() {
        return house;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        if (clientName != null && !clientName.trim().isEmpty()) {
            this.clientName = clientName;
        } else {
            this.clientName = "Unknown Client";
        }
    }

    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
            this.clientName = student.getName(); 
        } else {
            System.out.println("Warning: No student assigned");
        }
    }

    public void setHouse(House house) {
        if (house != null) {
            this.house = house;
        } else {
            System.out.println("Warning: No house assigned");
        }
    }

    public void setStartDate(String startDate) {
        if (startDate != null && !startDate.isEmpty()) {
            this.startDate = startDate;
        } else {
            this.startDate = "Not Set";
        }
    }

    public void setEndDate(String endDate) {
        if (endDate != null && !endDate.isEmpty()) {
            this.endDate = endDate;
        } else {
            this.endDate = "Not Set";
        }
    }

    public void setContractValue(double contractValue) {
        if (contractValue > 0) {
            this.contractValue = contractValue;
        } else {
            this.contractValue = 0.0;
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        } else {
            this.status = "Pending";
        }
    }

    @Override
    public String toString() {
        String studentName = (student != null) ? student.getName() : "None";
        return "Contract [ID=" + getId() + ", Student=" + studentName + ", Value=" + contractValue + ", Status=" + status + "]";
    }
}