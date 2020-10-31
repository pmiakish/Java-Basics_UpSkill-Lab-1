package com.epam.arrraysofarrays;

public class MatrixPrinter {
    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.printf("%5d ", item);
            }
            System.out.println();
        }
    }
}
