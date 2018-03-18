package lesson01.task01;

import java.util.Scanner;

public class DigitConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        printBin(number);
        printOct(number);
        printHex(number);

    }

    public static void printHex(int number) {

        String result = "";
        char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        do {
            result = hexArray[number%16] + result;
            number = number/16;
        } while (number > 0);

        System.out.println(result);
    }

    public static void printOct(int number) {

        String result = "";

        do {
            result = "" + number%8 + result;
            number = number/8;
        } while (number > 0);

        System.out.println(result);
    }

    public static void printBin(int number) {

        String result = "";

        do {
            result = "" + number%2 + result;
            number = number/2;
        } while (number > 0);

        System.out.println(result);
    }
}
