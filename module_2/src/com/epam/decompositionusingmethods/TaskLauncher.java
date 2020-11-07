package com.epam.decompositionusingmethods;

public class TaskLauncher {

    // task 01
    private static final int NUMBER_A = 252;
    private static final int NUMBER_B = 27;

    public static void main(String[] args) {

        // task 01
        int divisorFirstTask = NumbersAnalyzer.findGreatestCommonDivisor(NUMBER_A, NUMBER_B);
        if (divisorFirstTask != -1) {
            System.out.println("\n--- TASK 01 ---\nThe greatest common divisor of numbers " + NUMBER_A + " and " +
                    NUMBER_B + " is " + divisorFirstTask);
            int multipleFirstTask = NumbersAnalyzer.findLeastCommonMultiple(NUMBER_A, NUMBER_B);
            System.out.println("The least common multiple of numbers " + NUMBER_A + " and " +
                    NUMBER_B + " is " + multipleFirstTask);
        } else {
            System.out.println("\n--- TASK 01 ---\nIncorrect parameters!");
        }

    }
}
