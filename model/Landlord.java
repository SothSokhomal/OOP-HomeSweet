package model;
import java.util.ArrayList;

public class Landlord {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private ArrayList<House> houses = new ArrayList<>();

    public Landlord(String name, String phone, String email, String address){
        this.id = idCounter++;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void addHouse(House h) { this.houses.add(h); }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Landlord [id=" + id + ", name=" + name + "]";
    }
}