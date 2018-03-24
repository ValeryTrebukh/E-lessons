package classjournal.utils;

import java.util.Scanner;

public class Helper {
    private static Scanner sc = new Scanner(System.in);

    public static String requestString() {
        String result = null;

        while (result == null || result.isEmpty()) {
            result = sc.nextLine();
        }

        return result;
    }

    public static int requestInt() {

        while (!sc.hasNextInt()) {
            sc.next();
        }

        return sc.nextInt();
    }
}
