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
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        this.username = username.trim();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            throw new IllegalArgumentException("Invalid email address: must contain '@' and end with '.com'.");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number: must be exactly 10 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8 || !password.matches(".*[!@#$%^&*()].*")) {
            throw new IllegalArgumentException("Invalid password: must be at least 8 characters and contain a special character (!@#$%^&*()).");
        }
        this.password = password;
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
