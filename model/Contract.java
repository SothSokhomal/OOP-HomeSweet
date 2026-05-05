package model;

public class Contract {
    private static int idCounter = 1;
    private int id;
    private Student student;
    private House house;
    private String startDate;
    private String endDate;
    private double rentPrice;
    private OrderStatus status;

    public Contract(String clientName, String startDate, String endDate, double rentPrice, String status, Student student, House house){
        this.id = idCounter++;
        this.setStudent(student);
        this.setHouse(house);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setRentPrice(rentPrice);
        this.setOrderStatus(status);
    }

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public House getHouse() { return house; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getContractValue() { return rentPrice; }
    public String getStatus() { return status.name(); }

        private void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            System.err.println("Invalid student. Contract will not be linked to a student.");
        }
    }

    private void setHouse(House house) {
        if (house != null) {
            this.house = house;
        } else {
            System.err.println("Invalid house. Contract will not be linked to a house.");
        }
    }

    private void setStartDate(String startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            System.err.println("Invalid start date. Contract will not have a valid start date.");
        }
    }

    private void setEndDate(String endDate) {
        if (endDate != null) {
            this.endDate = endDate;
        } else {
            System.err.println("Invalid end date. Contract will not have a valid end date.");
        }
    }

    private void setRentPrice(double rentPrice) {
        if (rentPrice > 0) {
            this.rentPrice = rentPrice;
        } else {
            System.err.println("Invalid rent price. Contract will not have a valid rent price.");
        }
    }

    public void setOrderStatus(String status) {
        if(status != null){
            this.status = OrderStatus.fromString(status);
        } else {
            this.status = OrderStatus.PENDING;
        }
    }

    @Override
    public String toString() {
        return "Contract [ID=" + id + ", Student=" + student.getName() + ", House=" + house.getAddress() + "]";
    }
}