
// main class to test the Staff class and its methods
public class StaffMain {
    public static void main(String[] args) {
        // creating an instance of the Staff class and testing the getter and setter
        // methods
        Staff s1 = new Staff("Rose", 1, "Software Engineer");
        System.out.println(s1.getName());
        System.out.println(s1.getId());
        System.out.println(s1.getRole());

        // update the attributes of the Staff class using the setter methods
        s1.setRole("Students in year 2");
        System.out.println(s1.getRole());
    }
}
