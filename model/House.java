package model;

public class House {
    private static int idCounter = 1;
    private int id;
    private String address;
    private boolean isAvailable;
    private Landlord landlordName;
    private String city;
    private double rentPrice;

    public House(String address, Landlord landlordName, boolean isAvailable, String city, double rentPrice){
        this.id = idCounter++;
        this.setAddress(address);
        this.setLandlord(landlordName);
        this.setCity(city);
        this.setAvailable(isAvailable);
        this.setRentPrice(rentPrice);
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public boolean isAvailable() { 
        return isAvailable; 
    }

    public Landlord getLandlordName() {
        return landlordName;
    }

    public String getCity() {
        return city;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } 
        else {
            this.address = "Unknown Address";
        }
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setLandlord(Landlord landlordName) {
        this.landlordName = landlordName;
    }

    public void setRentPrice(double rentPrice) {
        if (rentPrice > 0) {
            this.rentPrice = rentPrice;
        } else {
            throw new IllegalArgumentException("Rent price must be positive: " + rentPrice);
        }
    }

    public void setCity(String city2) {
        if (city2 != null && !city2.trim().isEmpty()) {
            this.city = city2;
        } else {
            this.city = "Unknown City";
        }
    }

    public void setOwner(Landlord landlord) {
        this.landlordName = landlord;
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", address=" + address + ", city=" + city + 
            ", landlord=" + landlordName.getName() + ", isAvailable=" + isAvailable + 
            ", rentPrice=" + rentPrice + "]";
    }

    
}