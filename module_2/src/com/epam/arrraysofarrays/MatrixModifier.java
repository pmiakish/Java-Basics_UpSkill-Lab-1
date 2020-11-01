package com.epam.arrraysofarrays;

public class MatrixModifier {

    // task_08
    public static boolean replaceColumns(int[][] matrix, int firstColumn, int secondColumn) {
        boolean isModified = false;
        if (firstColumn > 0 && firstColumn <= matrix[0].length && secondColumn > 0 && secondColumn <= matrix[0].length
                && firstColumn != secondColumn) {
            int temp;
            for (int i = 0; i < matrix.length; i++) {
                temp = matrix[i][firstColumn - 1];
                matrix[i][firstColumn - 1] = matrix[i][secondColumn - 1];
                matrix[i][secondColumn - 1] = temp;
            }
            isModified = true;
        }
        return isModified;
    }

}
