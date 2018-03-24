package classjournal.view;

import classjournal.entity.Student;

import java.util.List;

public class JournalView {

    public void printMenu() {
        System.out.println("\n1 - SHOW ALL\t2 - ADD STUDENT\t0 - EXIT");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStudents(List<Student> students) {
        for(Student st : students) {
            System.out.println(st);
        }
    }
}
