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

    public static int countOccurrencesOfCharacter(String str, char[] chars) {
        int occurrencesOfCharacter = 0;
        for (char ch : chars) {
            occurrencesOfCharacter += countOccurrencesOfCharacter(str, ch);
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
        final int STR_LENGTH = str.length();
        int counterOfCharacters = 0;
        for (int i = 0; i < STR_LENGTH; i++) {
            char anotherCase = (isUpperCaseCounting) ? Character.toLowerCase(str.charAt(i)) : Character.toUpperCase(str.
                    charAt(i));
            if (str.charAt(i) != anotherCase) {
                counterOfCharacters++;
            }
        }
        return counterOfCharacters;
    }

}
