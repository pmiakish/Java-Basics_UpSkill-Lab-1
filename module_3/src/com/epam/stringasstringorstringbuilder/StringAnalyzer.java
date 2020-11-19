package com.epam.stringasstringorstringbuilder;

public class StringAnalyzer {

    // task 01
    public static int findMostAmountOfConsecutiveSpaces(String str) {
        final int STR_LENGTH = str.length();
        int mostAmountOfConsecutiveSpaces = 0;
        int counterOfSpaces = (str.charAt(0) == ' ') ? 1 : 0;
        for (int i = 1; i < STR_LENGTH; i++) {
            if (str.charAt(i) == ' ') {
                counterOfSpaces++;
            } else if (str.charAt(i - 1) == ' ' && counterOfSpaces > mostAmountOfConsecutiveSpaces) {
                mostAmountOfConsecutiveSpaces = counterOfSpaces;
                counterOfSpaces = 0;
            } else if (str.charAt(i - 1) == ' ' && counterOfSpaces <= mostAmountOfConsecutiveSpaces) {
                counterOfSpaces = 0;
            }
        }
        return Math.max(mostAmountOfConsecutiveSpaces, counterOfSpaces);
    }

    // task 03
    public static boolean checkIfWordIsPalindrome(String str) {
        return str.toLowerCase().contentEquals(new StringBuilder(str.toLowerCase()).reverse());
    }

    // tasks 05, 10
    public static int countOccurrencesOfCharacter(String str, char ch) {
        int occurrencesOfCharacter = 0;
        for (int i = str.indexOf(ch); i != -1; i = str.indexOf(ch, i + 1)) {
            occurrencesOfCharacter++;
        }
        return occurrencesOfCharacter;
    }

    // task 08
    public static String findLongestWord(String str) {
        String[] words = str.split(" ");
        int indexOfLongestWord = 0;
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > words[indexOfLongestWord].length()) {
                indexOfLongestWord = i;
            }
        }
        return words[indexOfLongestWord];
    }

    // task 09
    public static int countCharactersInUpperOrLowerCase(String str, boolean isUpperCaseCounting) {
        final int ASCII_FIRST_UPPER_CASE_CHARACTER = 65;
        final int ASCII_LAST_UPPER_CASE_CHARACTER = 90;
        final int ASCII_FIRST_LOWER_CASE_CHARACTER = 97;
        final int ASCII_LAST_LOWER_CASE_CHARACTER = 122;
        final int STR_LENGTH = str.length();
        int counterOfCharacters = 0;
        if (isUpperCaseCounting) {
            for (int i = 0; i < STR_LENGTH; i++) {
                int charAsciiNumber = str.charAt(i);
                if (charAsciiNumber >= ASCII_FIRST_UPPER_CASE_CHARACTER && charAsciiNumber <=
                        ASCII_LAST_UPPER_CASE_CHARACTER) {
                    counterOfCharacters++;
                }
            }
        } else {
            for (int i = 0; i < STR_LENGTH; i++) {
                int charAsciiNumber = str.charAt(i);
                if (charAsciiNumber >= ASCII_FIRST_LOWER_CASE_CHARACTER && charAsciiNumber <=
                        ASCII_LAST_LOWER_CASE_CHARACTER) {
                    counterOfCharacters++;
                }
            }
        }
        return counterOfCharacters;
    }

    // task 10
    public static String[] splitStringIntoSentences(String str) {
        return str.split("\\.+\\s*|!+\\s*|\\?+\\s*");
    }

}
