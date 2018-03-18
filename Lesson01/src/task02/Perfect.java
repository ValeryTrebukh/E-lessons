package lesson01.task02;

import java.util.Scanner;

public class Perfect {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int[] perfects = getPerfectNumbers(number);

        for(int i : perfects) {
            if(i!=0)
                System.out.println(i);
        }
    }

    static int[] getPerfectNumbers(int number) {

        int[] result = new int[10];
        int count = 0;

        for (int i = 2; i <= number; i++) {
            if(isPerfect(i)) {
                result[count] = i;
                count++;
            }
        }
        return result;
    }

    static boolean isPerfect(int number) {
        if(number%2 != 0) return false;

        int limit = (int)Math.sqrt(number);
        int sum = 1;

        for (int i = 2; i <= limit; i++) {
            if (number%i==0) {
                sum = sum + i + number / i;
            }
        }
        return sum == number;
    }
}
