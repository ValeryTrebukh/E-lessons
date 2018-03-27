package task0502.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    private static Scanner sc = new Scanner(System.in);

    public static String requestWord(String regex) {
        String str = null;

        while (true) {
            str = sc.next();
            if (isValid(str, regex)) {
                return str;
            }
            System.out.println("Try again");
        }
    }

    private static boolean isValid(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        return m.matches();
    }

    public static int requestInt() {

        while (!sc.hasNextInt()) {
            sc.next();
        }

        return sc.nextInt();
    }

    public static String requestString() {
        String result = null;

        while (result == null || result.isEmpty()) {
            result = sc.nextLine();
        }

        return result;
    }
}
