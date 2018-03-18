package lesson01.task03;

import java.util.Scanner;

public class Pyramidom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if(number > 0 && number < 10)
            printPyramide(number);
    }

    public static void printPyramide (int number) {

        for (int i = 1; i <=number; i++) {
            for(int j = 1; j <= number - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for (int j = i-1; j > 0; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}