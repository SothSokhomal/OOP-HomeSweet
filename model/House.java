package model;

public class House {
    private static int idCounter = 1;
    private int id;
    private String address;
    private String landlordName;
    private boolean isAvailable;
    private double rentPrice;

    public House(String address, Landlord landlord, boolean isAvailable, double rentPrice){
        this.id = idCounter++;
        this.setAddress(address);
        this.setLandlordName(landlord != null ? landlord.getName() : "No Landlord");
        this.setAvailable(isAvailable);
        this.setRentPrice(rentPrice);
    }

    private int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    private boolean getIsAvailable() {
        return isAvailable;
    }
    public boolean isAvailable() { 
        return isAvailable; 
    }

    public void setAvailable(boolean isAvailable) { 
        this.isAvailable = isAvailable; 
    }


    public String getLandlordName() {
        return landlordName;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLandlordName(String landlordName) {
        if (landlordName != null && !landlordName.trim().isEmpty()) {
            this.landlordName = landlordName;
        } else {
            this.landlordName = "No Landlord Assigned";
        }
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", address=" + address + ", landlordName=" + landlordName + ", isAvailable=" + isAvailable + ", rentPrice=" + rentPrice + "]";
    }

    
}
