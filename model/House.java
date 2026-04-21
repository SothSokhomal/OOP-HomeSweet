package model;

public class House {
    private int id;
    private String address;
    private String landlordName;
    private boolean isAvailable;
    private double rent;

    public House(int id, String address, String landlordName, boolean isAvailable, double rent){
        this.setId(id);
        this.setAddress(address);
        this.setLandlordName(landlordName);
        this.setIsAvailable(isAvailable);
        this.setRent(rent);
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public double getRent() {
        return rent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", address=" + address + ", landlordName=" + landlordName + ", isAvailable=" + isAvailable + ", rent=" + rent + "]";
    }

    
}
