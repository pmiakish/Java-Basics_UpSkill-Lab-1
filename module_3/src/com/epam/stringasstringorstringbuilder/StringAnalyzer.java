package com.epam.stringasstringorstringbuilder;

public class StringAnalyzer {

    // task_01
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

    // task_03
    public static boolean checkIfWordIsPalindrome(String str) {
        return str.toLowerCase().contentEquals(new StringBuilder(str.toLowerCase()).reverse());
    }

    // task_05
    public static int countOccurrencesOfCharacter(String str, char ch) {
        int occurrencesOfCharacter = 0;
        for (int i = str.indexOf(ch); i != -1; i = str.indexOf(ch, i + 1)) {
            occurrencesOfCharacter++;
        }
        return occurrencesOfCharacter;
    }

    // task_08
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

}
