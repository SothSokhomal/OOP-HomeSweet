
public class Staff {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    Staff(int id, String name, String email, String phoneNumber, String password){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
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

    public String getPhoneNumber() {
        return phoneNumber;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
