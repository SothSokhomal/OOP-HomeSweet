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

    public Contract(String clientName, String startDate, String endDate, double contractValue, String status, Student student, House house){
        this.id = idCounter++;
        this.student = student;
        this.house = house;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractValue = contractValue;
        this.status = status;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Contract [ID=" + id + ", Student=" + student.getName() + ", House=" + house.getAddress() + "]";
    }
}