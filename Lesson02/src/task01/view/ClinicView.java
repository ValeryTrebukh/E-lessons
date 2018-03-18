package task01.view;

import task01.model.Patient;

public class ClinicView {

    public void print(Patient [] patients) {
        if (patients.length == 0) {
            System.out.println("No results matching your request.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public void println(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void printMenu() {
        System.out.println("Select from menu:");
        System.out.println("1 - select patients by diagnosis");
        System.out.println("2 - select patients by card id");
        System.out.println("3 - sort patients by last name");
        System.out.println("0 - exit from application");
        System.out.print("Your choice: ");
    }
}
