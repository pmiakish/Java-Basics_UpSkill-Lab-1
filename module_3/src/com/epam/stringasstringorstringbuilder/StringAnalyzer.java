package com.epam.stringasstringorstringbuilder;

public class StringAnalyzer {

    // task_01
    public static int findMostAmountOfConsecutiveSpaces(String str) {
        int result = -1;
        int counterOfSpaces = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                counterOfSpaces++;
            } else if (i != 0 && str.charAt(i - 1) == ' ' && counterOfSpaces > result) {
                result = counterOfSpaces;
                counterOfSpaces = 0;
            } else if (i != 0 && str.charAt(i - 1) == ' ' && counterOfSpaces <= result) {
                counterOfSpaces = 0;
            }
        }
        return (result != -1 && counterOfSpaces > result) ? counterOfSpaces : result;
    }

    // task_03
    public static boolean checkIfWordIsPalindrome(String str) {
        boolean result = false;
        StringBuilder reversedString = new StringBuilder(str.toLowerCase()).reverse();
        if (reversedString.toString().equals(str.toLowerCase())) {
            result = true;
        }
        return result;
    }

}
