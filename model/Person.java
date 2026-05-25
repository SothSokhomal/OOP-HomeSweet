package model;

import interfaces.Displayable;

public class Person implements Displayable {
    private static int nextId = 1;
    private int id;
    protected String name;
    protected String username;
    protected String email;
    protected String phoneNumber;
    protected String password;

    public Person(String name, String username, String email, String phoneNumber, String password) {
        this.id = nextId++;
        setName(name);
        setUsername(username);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username.trim();
        } else {
            this.username = "UnknownUser";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            this.name = "Unknown Name";
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

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name);
    }

    public void performRole() {
        System.out.println(name + " is performing a general role.");
    }
}
