package model;

public class Admin extends Person {
    private static int idCounter = 1;
    private String password;

    public Admin(String name, String email, String password) {
        super(idCounter++, name, email, "0000000000"); // default phone
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}