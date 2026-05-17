package model;

public class Person {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    protected String password;

    public Person(int id, String name, String email, String phoneNumber, String password) {
        this.id = id;
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Default Name";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            this.email = "error@error.com";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Please enter a valid 10-digit phone number");
            this.phoneNumber = "0000000000";
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
