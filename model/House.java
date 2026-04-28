package model;

public class House {
    private static int idCounter = 1;
    private int id;
    private String address;
    private Landlord landlord;
    private boolean isAvailable;
    private Landlord landlordName;
    private String city;
    private double rentPrice;

    public House(String address, Landlord landlordName, boolean isAvailable, String city, double rentPrice){
        this.id = idCounter++;
        this.address = address;
        this.landlord = landlord;
        this.isAvailable = isAvailable;
        this.rentPrice = rentPrice;
    }

    public int getId() { return id; }
    public String getAddress() { return address; }
    public double getRentPrice() { return rentPrice; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

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
        return "House [id=" + id + ", address=" + address + ", available=" + isAvailable + "]";
    }
}