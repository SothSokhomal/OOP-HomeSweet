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

    
    public Contract(Student student, House house, String startDate, String endDate, double contractValue, String status){
        this.id = idCounter++;
        this.setStudent(student);
        this.setHouse(house);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setContractValue(contractValue);
        this.setStatus(status);
    }
    public int getContractId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public House getHouse() {
        return house;
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

    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            this.student = new Student("Unknown Student", "unknown@email.com", "0000000000", "defaultPass123", null, "00000000000000");
        }
    }

    public void setHouse(House house) {
        if (house != null) {
            this.house = house;
        } else {
            this.house = new House();

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
        return "Contract [contractId=" + id + ", student=" + student + ", house=" + house + ", startDate=" + startDate + ", endDate=" + endDate + ", contractValue=" + contractValue + ", status=" + status + "]";
    }

    
    
}
