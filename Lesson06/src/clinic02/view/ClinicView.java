package clinic02.view;

import clinic02.model.Patient;

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
    }


    public void printMenu() {
        System.out.println("\n1 - SELECT BY DIAGNOSIS    2 - SELECT BY ID    " +
                "3 - SORT BY NAME    4 - LOAD    5 - SAVE    0 - EXIT");
    }
}
