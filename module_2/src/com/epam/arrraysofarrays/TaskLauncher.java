package com.epam.arrraysofarrays;

import java.util.Locale;
import java.util.Scanner;

public class TaskLauncher {

    // TASK_01
    private static final int MIN_VALUE_OF_MATRIX = -25;
    private static final int MAX_VALUE_OF_MATRIX = 25;
    private static final int AMOUNT_OF_ROWS_OF_MATRIX = 5;
    private static final int AMOUNT_OF_COLUMNS_OF_MATRIX = 8;

    private static final int AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX = 7;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Module 2. Algorithmization. Arrays of arrays");
        System.out.print("Enter the task number: ");
        int taskNumber = console.nextInt();

        // Tasks
        switch (taskNumber) {
            case 1:
                int[][] generatedMatrix = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX, MAX_VALUE_OF_MATRIX,
                        AMOUNT_OF_ROWS_OF_MATRIX, AMOUNT_OF_COLUMNS_OF_MATRIX);
                System.out.println("\nThe generated matrix:");
                MatrixReader.printMatrix(generatedMatrix);
                System.out.println("\nThe odd columns of the matrix which have the first number greater than " +
                        "the last number:");
                MatrixSelectivePrinter.printOddColumnsIfFirstNumberIsGreaterThanLastNumber(generatedMatrix);
                break;
            case 2:
                int[][] generatedSquareMatrix = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX, MAX_VALUE_OF_MATRIX,
                        AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX, AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX);
                System.out.println("\nThe generated matrix:");
                MatrixReader.printMatrix(generatedSquareMatrix);
                MatrixSelectivePrinter.printDiagonalNumbers(generatedSquareMatrix);
                break;
            default:
                System.out.println("Task " + taskNumber + " not found");
                break;
        }
    }
}
