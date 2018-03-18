package task01.utils;

import task01.model.Patient;

import java.util.Scanner;

public class Helper {

    public static int requestInt() {

        Scanner sc = new Scanner(System.in);

        int result = -1;

        try {
            result = sc.nextInt();
        } catch (Exception ignore) {
        }

        return result;
    }

    public static String requestString() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter diagnosis: ");

        return sc.nextLine();
    }

    public static Patient[] getPatients(int number) {
        Patient[] result = new Patient[number];

        for(int i = 0; i < number; i++) {
            result[i] = new Patient(Generator.getLastName(), Generator.getFirstName(), Generator.getMiddleName(),
                    Generator.getAddress(), Generator.getPhone(), 1000+i, Generator.getDisease());
        }
        return result;
    }
}
