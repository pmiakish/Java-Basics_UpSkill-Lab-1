package com.epam.arrraysofarrays;

import java.util.Arrays;

public class MatrixModifier {

    // task_08
    public static boolean replaceColumns(int[][] matrix, int firstColumn, int secondColumn) {
        boolean isModified = false;
        if (firstColumn >= 0 && firstColumn < matrix[0].length && secondColumn >= 0 && secondColumn < matrix[0].length
                && firstColumn != secondColumn) {
            int temp;
            for (int i = 0; i < matrix.length; i++) {
                temp = matrix[i][firstColumn];
                matrix[i][firstColumn] = matrix[i][secondColumn];
                matrix[i][secondColumn] = temp;
            }
            isModified = true;
        }
        return isModified;
    }

    // task_12
    public static void sortRows(int[][] matrix, boolean descendingOrder) {
        for (int[] row : matrix) {
            Arrays.sort(row);
        }
        if (descendingOrder) {
            for (int i = 0; i < matrix.length; i++) {
                final int lastItemIndex = matrix[i].length - 1;
                final int middleOfRow = matrix[i].length / 2;
                int temp;
                for (int j = 0; j < middleOfRow; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][lastItemIndex - j];
                    matrix[i][lastItemIndex - j] = temp;
                }
            }
        }
    }

}
