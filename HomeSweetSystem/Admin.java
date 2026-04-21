package homeSweetSystem;

public class Admin {
    private int id;
    private String name;
    private String email;
    private String password;
    Admin(int id, String name, String email, String password){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
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
    public String getPassword() {
        return password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }

    
    
}
