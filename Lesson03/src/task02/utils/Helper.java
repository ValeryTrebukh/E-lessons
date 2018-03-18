package task02.utils;

import java.util.Scanner;

public class Helper {
    public static int requestInt(String message) {

        System.out.println(message);

        Scanner sc = new Scanner(System.in);

        int result = -1;

        try {
            result = sc.nextInt();
        } catch (Exception ignore) {
        }

        return result;
    }
}
