package classjournal.model;

import classjournal.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class JournalModel {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        students.add(student);

    }

    String requestFirstName() {
        return null;
    }

    String requestLastName() {
        return null;
    }

    String requestDateOfBirth() {
        return null;
    }

    String requestPhoneNumber() {
        return null;
    }

    String requestAddress() {
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }
}
