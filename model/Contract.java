package model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import interfaces.Displayable;
import interfaces.StatusManageable;

public class Contract implements Displayable, StatusManageable {
    private static int nextContractId = 1;
    private int id;
    private Student student;
    private House house;
    private LocalDate startDate;
    private LocalDate endDate;
    private double contractValue;
    private ContractStatus status;

    private static int contractCount = 0;

    public Contract(String clientName, String startDateStr, String endDateStr, double contractValue, String status,
            Student student, House house) {
        this.id = nextContractId++;
        setStudent(student);
        setHouse(house);
        setStartDate(startDateStr);
        setEndDate(endDateStr);
        setContractValue(contractValue);
        setContractStatus(status);
        contractCount++;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public House getHouse() {
        return house;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getContractValue() {
        return contractValue;
    }

    public ContractStatus getContractStatus() {
        return status;
    }

    // Returns String for backward compatibility
    public String getStatus() {
        return status.name();
    }

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
            this.endDate = LocalDate.now().plusYears(1);
        }
    }

    public void setContractValue(double contractValue) {
        if (contractValue >= 0) {
            this.contractValue = contractValue;
        } else {
            this.contractValue = 0;
        }
    }

    public void setContractStatus(String status) {
        if (status != null) {
            this.status = ContractStatus.fromString(status);
        } else {
            this.status = ContractStatus.PENDING;
        }
    }

    public boolean createContract() {
        if (student == null || house == null || !house.isAvailable()) {
            return false;
        }
        house.markUnavailable();
        student.setContract(this);
        this.status = ContractStatus.PENDING;
        System.out.println("Contract " + id + " created successfully.");
        return true;
    }

    public void activateContract() {
        if (status != ContractStatus.CANCELLED && status != ContractStatus.EXPIRED) {
            this.status = ContractStatus.ACTIVE;
        }
    }

    public void cancelContract() {
        this.status = ContractStatus.CANCELLED;
        if (house != null) house.markAvailable();
    }

    public void expireContract() {
        this.status = ContractStatus.EXPIRED;
        if (house != null) house.markAvailable();
    }

    public void viewDetails() {
        System.out.println("\n--- Contract Details ---");
        System.out.println("Contract ID  : " + id);
        System.out.println("Student      : " + (student != null ? student.getName() : "N/A"));
        System.out.println("House        : " + (house != null ? house.getAddress() + ", " + house.getCity() : "N/A"));
        System.out.println("Period       : " + startDate + " to " + endDate);
        System.out.println("Rent Price   : $" + contractValue);
        System.out.println("Status       : " + status.name());
    }

    public static int getContractCount() {
        return contractCount;
    }

    @Override
    public String getStatusText() {
        return status.name();
    }

    @Override
    public void displayStatus() {
        System.out.println("Contract Status: " + status.name());
    }

    @Override
    public void displayInfo() {
        System.out.println("Contract ID  : " + id);
        System.out.println("Student      : " + (student != null ? student.getName() : "N/A"));
        System.out.println("House        : " + (house != null ? house.getAddress() : "N/A"));
        System.out.println("Period       : " + startDate + " to " + endDate);
        System.out.println("Value        : $" + contractValue);
        System.out.println("Status       : " + status.name());
        if (house != null && house.getLandlord() != null) {
            System.out.println("Landlord     : " + house.getLandlord().getName());
        }
    }

    @Override
    public String toString() {
        return "Contract [ID=" + id + ", Student=" + (student != null ? student.getName() : "N/A")
                + ", House=" + (house != null ? house.getAddress() : "N/A")
                + ", Status=" + status.name() + "]";
    }
}
