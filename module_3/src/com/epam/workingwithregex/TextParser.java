package com.epam.workingwithregex;

public class TextParser {

    public static String sortParagraphsByNumberOfSentences(String text) {
        String[] paragraphs = parseIntoParagraphs(text);
        int[][] numberOfSentences = new int[paragraphs.length][2];
        for (int i = 0; i < numberOfSentences.length; i++) {
            numberOfSentences[i][0] = i;
            numberOfSentences[i][1] = parseIntoSentences(paragraphs[i]).length;
        }
        sortByDescendingOrder(numberOfSentences);
        StringBuilder sortedParagraphs = new StringBuilder();
        for (int i = 0; i < numberOfSentences.length; i++) {
            sortedParagraphs.append(paragraphs[numberOfSentences[i][0]]).append("\n");
        }
        return sortedParagraphs.toString();
    }

    public static String sortWordsByLengthInSentences(String text) {
        String[] sentences = parseIntoSentences(text);
        StringBuilder sortedSentences = new StringBuilder();
        for (String sentence : sentences) {
            String[] words = sentence.split("(?<=\\w)\\W+");
            int[][] numberOfCharacters = new int[words.length][2];
            for (int i = 0; i < words.length; i++) {
                numberOfCharacters[i][0] = i;
                numberOfCharacters[i][1] = words[i].length();
            }
            sortByDescendingOrder(numberOfCharacters);
            for (int i = 0; i < numberOfCharacters.length; i++) {
                sortedSentences.append(words[numberOfCharacters[i][0]]).append(" ");
            }
            sortedSentences.append("\n");
        }
        return sortedSentences.toString();
    }

    public static String sortWordsByNumberOfOccurrencesOfCharacter(String text, char specifiedCharacter) {
        String[] sentences = parseIntoSentences(text);
        StringBuilder sortedSentences = new StringBuilder();
        for (String sentence : sentences) {
            String[] words = sentence.split("(?<=\\w)\\W+");
            sortAlphabetically(words);
            int[][] numberOfCharacters = new int[words.length][2];
            for (int i = 0; i < words.length; i++) {
                int counterOfOccurrences = 0;
                int indexOfSpecifiedCharacter = words[i].indexOf(specifiedCharacter);
                while (indexOfSpecifiedCharacter != -1) {
                    counterOfOccurrences++;
                    indexOfSpecifiedCharacter = words[i].indexOf(specifiedCharacter, indexOfSpecifiedCharacter + 1);
                }
                numberOfCharacters[i][0] = i;
                numberOfCharacters[i][1] = counterOfOccurrences;
            }
            sortByDescendingOrder(numberOfCharacters);
            for (int i = 0; i < numberOfCharacters.length; i++) {
                sortedSentences.append(words[numberOfCharacters[i][0]]).append(" ");
            }
            sortedSentences.append("\n");
        }
        return sortedSentences.toString();
    }

    private static String[] parseIntoParagraphs(String text) {
        return text.split("\n");
    }

    private static String[] parseIntoSentences(String text) {
        return text.split("(?<=[\\.\\?!])\\s+");
    }

    private static void sortAlphabetically(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareToIgnoreCase(words[j]) > 0) {
                    String temp = words[j];
                    words[j] = words[i];
                    words[i] = temp;
                }
            }
        }
    }

    private static void sortByDescendingOrder(int[][] array) {
        int temp;
        int temp2;
        for (int i = 1; i < array.length; i++) {
            if (array[i][1] > array[i - 1][1]) {
                temp = array[i][1];
                temp2 = array[i][0];
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j][1] < temp && j != 0) {
                        array[j + 1][1] = array[j][1];
                        array[j + 1][0] = array[j][0];
                    } else if (array[j][1] < temp && j == 0) {
                        array[j + 1][1] = array[j][1];
                        array[j + 1][0] = array[j][0];
                        array[j][1] = temp;
                        array[j][0] = temp2;
                    }
                    else {
                        array[j + 1][1] = temp;
                        array[j + 1][0] = temp2;
                        break;
                    }
                }
            }
        }
    }

}
