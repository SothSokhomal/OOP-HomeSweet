// class staff with private attributes Name, Id, Role 
// and public getter and setter methods for each attribute. 
// The setter methods should include validation to ensure that the Name and Role are not null or empty, and the Id is a positive integer.
class Staff {
    // using encapsulation to protect the data and provide controlled access to it
    // through getter and setter methods
    private String Name;
    private int Id;
    private String Role;

    // constructor to initialize the attributes of the Staff class
    Staff(String Name, int Id, String Role) {
        this.Name = Name;
        this.Id = Id;
        this.Role = Role;
    }

    // getter methods to retrieve the values of the attributes
    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public String getRole() {
        return Role;
    }

    // setter methods to set the values of the attributes with validation
    public void setName(String Name) {
        // validation to ensure that the Name is not null or empty
        if (Name != null && !Name.isEmpty()) {
            this.Name = Name;
        } else {
            System.out.println("Invalid name. Name cannot be null or empty.");
        }
    }

    public void setId(int Id) {
        this.Id = Id;

    }

    public void setRole(String Role) {
        // validation to ensure that the Role is not null or empty
        if (Role != null && !Role.isEmpty()) {
            this.Role = Role;
        } else {
            System.out.println("Invalid role. Role cannot be null or empty.");
        }
    }
}