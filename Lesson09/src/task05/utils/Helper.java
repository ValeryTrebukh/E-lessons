package task05.utils;

import java.io.File;
import java.util.Scanner;

public class Helper {

    public static File getDirectory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base directory location.");
        String path = sc.nextLine();
        File baseDir = new File(path);

        while(!baseDir.exists() || !baseDir.isDirectory()) {
            System.out.println("Incorrect directory location. Try again or enter 'EXIT' to close application.");
            path = sc.nextLine();
            if(path.equals("EXIT")) {
                System.exit(0);
            }
            baseDir = new File(path);
        }
        return baseDir;
    }

    public static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter destination file location.");
        String path = sc.nextLine();
        File destination = new File(path);
        while(!destination.exists() || destination.isDirectory()) {
            System.out.println("Incorrect file location. Try again or enter 'EXIT' to close application.");
            path = sc.nextLine();
            if(path.equals("EXIT")) {
                System.exit(0);
            }
            destination = new File(path);
        }
        return destination;
    }

    public static String getSymbol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character.");
        String smb = sc.nextLine();

        while(smb.length() == 0) {
            System.out.println("Cannot be empty. Enter valid character");
            smb = sc.nextLine();
        }
        return smb;
    }
}
