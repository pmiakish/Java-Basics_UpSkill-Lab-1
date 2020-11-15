package com.epam.stringasstringorstringbuilder;

public class TaskLauncher {

    // task_01
    private static final String STRING_INCLUDING_SPACES = "   This string   is intended     to count the maximum     " +
            "number of        consecutive  spaces  .";

    public static void main(String[] args) {
        // task_01
        System.out.println("\n--- TASK 01 ---\nThe max number of consecutive spaces in the following string:\n\"" +
                STRING_INCLUDING_SPACES + "\"\nis " + StringAnalyzer.
                findMostAmountOfConsecutiveSpaces(STRING_INCLUDING_SPACES));

    }
}
