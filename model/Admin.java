package model;

public class Admin {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String email;
    private String password;
    
    public Admin(String name, String email, String password){
        this.id = idCounter++;
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
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
    public String getPassword() {
        return password;
    }
    private void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be empty.");
            this.name = "Unknown Admin";
        }
    }
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.toLowerCase().endsWith(".com")) {
            this.email = email;
        } else {
            System.out.println("Error: Invalid email format for " + name);
            this.email = "invalid@email.com";
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }

    
    
}
