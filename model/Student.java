package model;

public class Student {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String PhoneNumber; 
    private String password;
    private String nationalId;     

    public Student(String name, String email, String phoneNumber, String password, String nationalId){
        this.id = idCounter++;
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setPassword(password);
        this.setNationalId(nationalId);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getPassword() {
        return password;
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

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{10}")) {
            this.PhoneNumber = phoneNumber;
        } else {

            this.PhoneNumber = "0000000000"; 
            System.out.println("Please enter a valid 10-digit phone number");
        }
    }

    public void setPassword(String password) {
        if (password != null && password.length() >= 8 && password.matches(".*[!@#$%^&*()].*")) {
            this.password = password;
        } else {
            this.password = "SecurityError123!";
        }
    }

    public void setNationalId(String nationalId) {
        if (nationalId != null && nationalId.matches("\\d{14}")) {
            this.nationalId = nationalId;
        } else {

            this.nationalId = "00000000000000";
            System.out.println("Please enter a valid 14-digit national ID");
        }
    }

    @Override
    public String toString() {
        return "Student [id="  + id + ", name=" + name + ", email=" + email + ", PhoneNumber=" + PhoneNumber + ", nationalId=" + nationalId + "]";
    }
}