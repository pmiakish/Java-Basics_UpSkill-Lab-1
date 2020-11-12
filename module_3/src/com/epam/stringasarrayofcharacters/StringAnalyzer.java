package com.epam.stringasarrayofcharacters;

public class StringAnalyzer {

    private static final int ASCII_NUMBER_OF_FIRST_DIGIT = 48;
    private static final int ASCII_NUMBER_OF_LAST_DIGIT = 57;

    // task 03
    public static int countDigits(String str) {
        int counterOfDigits = 0;
        final char[] characters = str.toCharArray();
        for (char ch : characters) {
            if (ch >= ASCII_NUMBER_OF_FIRST_DIGIT && ch <= ASCII_NUMBER_OF_LAST_DIGIT) {
                counterOfDigits++;
            }
        }
        return counterOfDigits;
    }

    // task 04
    public static int countNumbers(String str) {
        int counterOfNumbers = 0;
        boolean foundNumber = false;
        final char[] characters = str.toCharArray();
        for (char ch : characters) {
            if (foundNumber && !(ch >= ASCII_NUMBER_OF_FIRST_DIGIT && ch <= ASCII_NUMBER_OF_LAST_DIGIT) && ch != '.' &&
                    ch != ',') {
                foundNumber = false;
            } else if (!foundNumber && ch >= ASCII_NUMBER_OF_FIRST_DIGIT && ch <= ASCII_NUMBER_OF_LAST_DIGIT) {
                counterOfNumbers++;
                foundNumber = true;
            }
        }
        return counterOfNumbers;
    }

}
