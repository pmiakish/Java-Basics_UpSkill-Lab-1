package com.epam.arrraysofarrays;

public class MatrixReader {
    public static void printMatrix(int[][] generatedMatrix) {
        System.out.println();
        for (int[] row : generatedMatrix) {
            for (int item : row) {
                System.out.printf("%5d ", item);
            }
            System.out.println();
        }
    }
}
