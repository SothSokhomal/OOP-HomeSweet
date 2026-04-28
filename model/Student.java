package model;

public class Student {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String phonNumber;
    private String password;
    private Contract contract; // Changed to Contract object
    private String nationalId;     

    public Student(String name, String email, String phonNumber, String password, Contract contract, String nationalId){
        this.id = idCounter++;
        this.name = name;
        this.email = email;
        this.phonNumber = phonNumber;
        this.password = password;
        this.contract = contract;
        this.nationalId = nationalId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setContract(Contract contract) { this.contract = contract; }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", hasContract=" + (contract != null) + "]";
    }
}