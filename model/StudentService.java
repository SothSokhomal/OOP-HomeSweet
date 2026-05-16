package model;

import java.util.ArrayList;
import java.util.List;
import interfaces.Searchable;

public class StudentService implements Searchable<Student> {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewStudents() {
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.displayInfo();
        }
    }

    @Override
    public List<Student> search(String keyword) {
        List<Student> results = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }

    @Override
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
