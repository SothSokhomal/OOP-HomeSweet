package model;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Contract implements Displayable, StatusManageable {
    private static int idCounter = 1;
    private int id;
    private Student student;
    private House house;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rentPrice;
    private OrderStatus status;

    public Contract(String clientName, String startDateStr, String endDateStr, double rentPrice, String status, Student student, House house){
        this.id = idCounter++;
        this.setStudent(student);
        this.setHouse(house);
        this.setStartDate(startDateStr);
        this.setEndDate(endDateStr);
        this.setRentPrice(rentPrice);
        this.setOrderStatus(status);
    }

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public House getHouse() { return house; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
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

    private void setStartDate(String startDateStr) {
        if (startDateStr != null) {
            try {
                this.startDate = LocalDate.parse(startDateStr);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid start date format. Using current date.");
                this.startDate = LocalDate.now();
            }
        } else {
            System.err.println("Invalid start date. Contract will not have a valid start date.");
            this.startDate = LocalDate.now();
        }
    }

    private void setEndDate(String endDateStr) {
        if (endDateStr != null) {
            try {
                this.endDate = LocalDate.parse(endDateStr);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid end date format. Using current date + 1 year.");
                this.endDate = LocalDate.now().plusYears(1);
            }
        } else {
            System.err.println("Invalid end date. Contract will not have a valid end date.");
            this.endDate = LocalDate.now().plusYears(1);
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

    public void viewDetails() {
        System.out.println("\n--- Contract Details ---");
        System.out.println("Contract ID : " + id);
        System.out.println("Student     : " + student.getName());
        System.out.println("House       : " + house.getAddress() + ", " + house.getCity());
        System.out.println("Period      : " + startDate + " to " + endDate);
        System.out.println("Rent Price  : $" + rentPrice);
        System.out.println("Status      : " + status.name());
    }

    @Override
    public String toString() {
        return "Contract [ID=" + id + ", Student=" + student.getName() + ", House=" + house.getAddress() + ", Status=" + status.name() + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void updateStatus(String status) {
        setOrderStatus(status);
    }

    @Override
    public String getCurrentStatus() {
        return getStatus();
    }
}