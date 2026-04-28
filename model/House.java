package model;

public class House {
    private static int idCounter = 1;
    private int id;
    private String address;
    private Landlord landlord;
    private boolean isAvailable;
    private double rentPrice;

    public House(String address, Landlord landlord, boolean isAvailable, double rentPrice){
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

    @Override
    public String toString() {
        return "House [id=" + id + ", address=" + address + ", available=" + isAvailable + "]";
    }
}