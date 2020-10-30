package com.epam.arrraysofarrays;

import java.util.Locale;
import java.util.Scanner;

public class TaskLauncher {

    private static final int MIN_VALUE_OF_MATRIX = -25;
    private static final int MAX_VALUE_OF_MATRIX = 25;
    private static final int AMOUNT_OF_ROWS_OF_MATRIX = 5;
    private static final int AMOUNT_OF_COLUMNS_OF_MATRIX = 8;
    private static final int AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX = 7;
    private static final int ROW_FOR_PRINT_NUMBER = 3;
    private static final int COLUMN_FOR_PRINT_NUMBER = 2;
    private static final int ORDER_OF_SQUARE_MATRIX = 8;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Module 2. Algorithmization. Arrays of arrays");
        System.out.print("Enter the task number: ");
        int taskNumber = console.nextInt();

        // Tasks
        switch (taskNumber) {
            case 1:
                int[][] generatedMatrixForFirstTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX, AMOUNT_OF_ROWS_OF_MATRIX, AMOUNT_OF_COLUMNS_OF_MATRIX);
                if (generatedMatrixForFirstTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixReader.printMatrix(generatedMatrixForFirstTask);
                    System.out.println("\nThe odd columns of the matrix which have the first number greater than " +
                            "the last number:");
                    MatrixSelectivePrinter.
                            printOddColumnsIfFirstNumberIsGreaterThanLastNumber(generatedMatrixForFirstTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 2:
                int[][] generatedMatrixForSecondTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX, AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX,
                        AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX);
                if (generatedMatrixForSecondTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixReader.printMatrix(generatedMatrixForSecondTask);
                    MatrixSelectivePrinter.printDiagonalNumbers(generatedMatrixForSecondTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 3:
                int[][] generatedMatrixForThirdTask = MatrixBuilder.generateMatrix(MIN_VALUE_OF_MATRIX,
                        MAX_VALUE_OF_MATRIX,AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX,
                        AMOUNT_OF_ROWS_AND_COLUMNS_OF_SQUARE_MATRIX);
                if (generatedMatrixForThirdTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixReader.printMatrix(generatedMatrixForThirdTask);
                    MatrixSelectivePrinter.printKRowAndPColumn(generatedMatrixForThirdTask, ROW_FOR_PRINT_NUMBER,
                            COLUMN_FOR_PRINT_NUMBER);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            case 4:
                int[][] generatedMatrixForFourthTask =
                        MatrixBuilder.buildMatrixAccordingToPattern1(ORDER_OF_SQUARE_MATRIX);
                if (generatedMatrixForFourthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixReader.printMatrix(generatedMatrixForFourthTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
            case 5:
                int[][] generatedMatrixForFifthTask = MatrixBuilder.
                                buildMatrixAccordingToPattern2(ORDER_OF_SQUARE_MATRIX);
                if (generatedMatrixForFifthTask != null) {
                    System.out.println("\nThe generated matrix:");
                    MatrixReader.printMatrix(generatedMatrixForFifthTask);
                } else {
                    System.out.println("\nThe matrix with the specified parameters can't be generated!");
                }
                break;
            default:
                System.out.println("Task " + taskNumber + " not found");
                break;
        }
    }
}
