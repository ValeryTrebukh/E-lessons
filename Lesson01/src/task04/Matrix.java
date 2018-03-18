package lesson01.task04;

import java.util.Scanner;

public class Matrix {

    static void run() {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if(number <= 0) return;

        int [][] matrix = createMatrix(number);

        printMatrix(matrix);
        rotateMatrix(matrix);
        printMatrix(matrix);
    }

    static int[][] createMatrix(int size) {

        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrix[i][j] = (int)(Math.random()*200-100);
            }
        }
        return matrix;
    }

    static void printMatrix (int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void rotateMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] rotated = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                rotated[i][j] = matrix[j][size - 1 - i];
            }
        }
        System.arraycopy(rotated,0, matrix,0, size);
    }
}
