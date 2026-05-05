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

    public Contract(String clientName, String startDate, String endDate, double d, OrderStatus status, Student student, House house){
        this.id = idCounter++;
        this.student = student;
        this.house = house;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Contract(Student student2, House house2, String startDate2, String endDate2, double rentPrice,
            OrderStatus pending) {
        //TODO Auto-generated constructor stub
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
        this.student = student;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() { return id; }
    public Student getStudent() { return student; }
    public House getHouse() { return house; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getContractValue() { return contractValue; }
    public OrderStatus getStatus() { return status; }

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