package model;

import java.util.ArrayList;
import java.util.List;
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void viewStudents() {
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.displayInfo();
        }
    }

    public List<Student> search(String keyword) {
        List<Student> results = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Student findByUsername(String username) {
        for (Student s : students) {
            if (s.getUsername().equals(username)) {
                return s;
            }
        }
        return null;
    }
}
