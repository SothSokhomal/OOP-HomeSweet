package model;

public class House implements Displayable, StatusManageable {
    private static int idCounter = 1;
    private int id;
    private String address;
    private boolean isAvailable;
    private Landlord landlord;
    private String city;
    private double rentPrice;

    public House(String address, Landlord landlord, boolean isAvailable, String city, double rentPrice){
        this.id = idCounter++;
        this.setAddress(address);
        this.setLandlord(landlord);
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

    public Landlord getLandlord() {
        return landlord;
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

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public void setRentPrice(double rentPrice) {
        if (rentPrice > 0) {
            this.rentPrice = rentPrice;
        } else {
            throw new IllegalArgumentException("Rent price must be positive: " + rentPrice);
        }
    }

    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city;
        } else {
            this.city = "Unknown City";
        }
    }

    @Override
    public String toString() {
        return "House [id=" + id + ", address=" + address + ", city=" + city + 
            ", landlord=" + (landlord != null ? landlord.getName() : "None") + ", isAvailable=" + isAvailable + 
            ", rentPrice=" + rentPrice + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public void updateStatus(String status) {
        if (status != null && status.equalsIgnoreCase("unavailable")) {
            this.isAvailable = false;
        } else if (status != null && status.equalsIgnoreCase("available")) {
            this.isAvailable = true;
        }
    }

    @Override
    public String getCurrentStatus() {
        return isAvailable ? "Available" : "Unavailable";
    }
}