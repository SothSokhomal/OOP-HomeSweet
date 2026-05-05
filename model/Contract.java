package model;

public class Contract {
    private static int idCounter = 1;
    private int id;
    private Student student;
    private House house;
    private String startDate;
    private String endDate;
    private double contractValue;
    private OrderStatus status;

    public Contract(String clientName, String startDate, String endDate, double contractValue, String status, Student student, House house){
        this.id = idCounter++;
        this.student = student;
        this.house = house;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractValue = contractValue;
        this.status = (status == null) ? OrderStatus.PENDING : OrderStatus.fromString(status);
    }

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public House getHouse() { return house; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getContractValue() { return contractValue; }
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