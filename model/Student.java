package model;

public class Student {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String phonNumber;
    private String password;
    private String contract;
    private String nationalId;

    public Student(String name, String email, String phonNumber, String password, String contract, String nationalId){
        this.id = idCounter++;
        this.setName(name);
        this.setEmail(email);
        this.setPhonNumber(phonNumber);
        this.setPassword(password);
        this.setContract(contract);
        this.setNationalId(nationalId);
    }

    private int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public String getPassword() {
        return password;
    }
    public String getContract() {
        return contract;
    }
    public String getNationalId() {
        return nationalId;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Default Student";
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            this.email = "student@error.com";
        }
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8 && password.matches(".*[!@#$%^&*()].*")) {
            this.password = password;
        } else {
            this.password = "SecurityError123!";
        }
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @Override
    public String toString() {
        return "Student [id="  + id + ", name=" + name + ", email=" + email + ", phonNumber=" + phonNumber + ", password=" + password + ", contract=" + contract + ", nationalId=" + nationalId + "]";
    }
}



