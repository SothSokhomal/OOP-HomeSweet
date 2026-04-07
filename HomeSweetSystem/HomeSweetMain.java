package HomeSweetSystem;

public class HomeSweetMain {
    public static void main(String[] args) {
        
        Landlord l1 = new Landlord(001, "Elizabeth", "123-456-7890", "abc123@gmail.com", "Phnom Penh");
        Admin a1 = new Admin(001, "John Doe", "johndoe@gmail.com", "password123");
        Student s1 = new Student(001, "Jane Smith", "janesmith@gmail.com", "987-654-3210", "studentpassword", "Contract A", "1234567890123");


        System.out.println(l1);
        System.out.println(a1);
        System.out.println(s1);
    }
}
