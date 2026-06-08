package model;

import interfaces.Displayable;

public abstract class Person implements Displayable {
    private static int nextId = 1;
    private int id;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;

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
        if (password != null && password.length() >= 8 && password.matches(".*[!@#$%^&*()].*")) {
            this.password = password;
        } else {
            System.out.println("Warning: Password must be at least 8 characters and contain a special character (!@#$%^&*()). Setting default password.");
            this.password = "SecurityError123!";
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("ID           : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Email        : " + email);
        System.out.println("Phone Number : " + phoneNumber);
    }

    public abstract void performRole();
}
