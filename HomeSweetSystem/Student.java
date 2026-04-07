package HomeSweetSystem;

public class Student {
    private int id;
    private String name;
    private String email;
    private String phonNumber;
    private String password;

    Student(int id, String name, String email, String phonNumber, String password){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPhonNumber(phonNumber);
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

    public String getPhonNumber() {
        return phonNumber;
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

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phonNumber=" + phonNumber
                + ", password=" + password + "]";
    }

    
    

}



