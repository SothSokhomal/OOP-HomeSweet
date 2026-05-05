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

    public Contract(String clientName, String startDate, String endDate, double d, OrderStatus status, Student student, House house){
        this.id = idCounter++;
        this.student = student;
        this.house = house;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentPrice = d;
        this.status = status;
    }

    public Contract(Student student2, House house2, String startDate2, String endDate2, double rentPrice,
            OrderStatus pending) {
        this.id = idCounter++;
        this.student = student2;
        this.house = house2;
        this.startDate = startDate2;
        this.endDate = endDate2;
        this.rentPrice = rentPrice;
        this.status = pending;
    }

    public static int getIdCounter() {
        return idCounter;
    }


    public Student getStudent1() {
        return student;
    }


    public House getHouse1() {
        return house;
    }

    public String getStartDate1() {
        return startDate;
    }


    public String getEndDate1() {
        return endDate;
    }



    public OrderStatus getStatus1() {
        return status;
    }

    
    public static void setIdCounter(int idCounter) {
        Contract.idCounter = idCounter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            System.err.println("Invalid student. Contract will not be linked to a student.");
        }
    }

    public void setHouse(House house) {
        if (house != null) {
            this.house = house;
        } else {
            System.err.println("Invalid house. Contract will not be linked to a house.");
        }
    }

    public void setStartDate(String startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            System.err.println("Invalid start date. Contract will not have a valid start date.");
        }
    }

    public void setEndDate(String endDate) {
        if (endDate != null) {
            this.endDate = endDate;
        } else {
            System.err.println("Invalid end date. Contract will not have a valid end date.");
        }
    }

    public void setRentPrice(double rentPrice) {
        if (rentPrice > 0) {
            this.rentPrice = rentPrice;
        } else {
            System.err.println("Invalid rent price. Contract will not have a valid rent price.");
        }
    }

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public House getHouse() { return house; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getContractValue() { return rentPrice; }
    public String getStatus() { return status.name(); }

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