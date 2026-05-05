package model;

public class Contract {
    private static int idCounter = 1;
    private int id;
    private Student student;
    private House house;
    private String startDate;
    private String endDate;
    private String status;

    public Contract(String clientName, String startDate, String endDate, String status, Student student, House house){
        this.id = idCounter++;
        this.student = student;
        this.house = house;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public static int getIdCounter() {
        return idCounter;
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



    public String getStatus() {
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

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "Contract [ID=" + id + ", Student=" + student.getName() + ", House=" + house.getAddress() + "]";
    }
}