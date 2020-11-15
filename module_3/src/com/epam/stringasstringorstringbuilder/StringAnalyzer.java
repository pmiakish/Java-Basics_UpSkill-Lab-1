package com.epam.stringasstringorstringbuilder;

public class StringAnalyzer {
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


}
