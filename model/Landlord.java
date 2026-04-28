package model;

public class Landlord {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Landlord(String name, String phone, String email, String address){
        this.id = idCounter++;
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
    }

    private int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown Landlord";
        }
    }

    private void setPhone(String phone) {
        if (phone != null && phone.matches("\\d{10}")) {
            this.phone = phone;
        } else {
            System.out.println("Please enter a valid 10-digit phone number");
        }
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            this.email = "landlord@error.com";
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } else {
            this.address = "Unknown Address";
        }
    }

    @Override
    public String toString() {
        return "LandLord [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + "]";
    }
    
}