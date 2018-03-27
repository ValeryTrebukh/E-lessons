package task0501;

import java.util.Scanner;

public class Helper {
    static Scanner sc = new Scanner(System.in);

    static int getInt() {
        while(!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }
}
