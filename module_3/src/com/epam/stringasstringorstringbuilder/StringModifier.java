package com.epam.stringasstringorstringbuilder;

public class StringModifier {

    // task_02
    public static String insertTextAfterSpecifiedSubstring(String str, String textToInsert, String specifiedSubstr) {
        return str.replace(specifiedSubstr, specifiedSubstr + textToInsert);
    }

    // task_04
    public static String concatenateSpecifiedWordFromAnotherWord(String donorWord, String specifiedWord) {
        final int LENGTH_OF_WORD = specifiedWord.length();
        StringBuilder resultStr = new StringBuilder();
        boolean areAllCharacters = true;
        for (int i = 0; i < LENGTH_OF_WORD; i++) {
            int indexOfSearchingLetter = donorWord.indexOf(specifiedWord.charAt(i));
            if (indexOfSearchingLetter != -1) {
                resultStr.append(donorWord.charAt(indexOfSearchingLetter));
            } else {
                areAllCharacters = false;
                break;
            }
        }
        return (areAllCharacters) ? resultStr.toString() : "";
    }

    // task_06
    public static String duplicateEachCharacter(String str) {
        char[] characters = str.toCharArray();
        char[] duplicateCharacters = new char[characters.length * 2];
        for (int i = 0; i < duplicateCharacters.length; i += 2) {
            int j = i / 2;
            duplicateCharacters[i] = characters[j];
            duplicateCharacters[i + 1] = characters[j];
        }
        return new String(duplicateCharacters);
    }

    // task_07
    public static String removeSpacesAndRepeatingCharacters(String str) {
        char[] characters = str.toCharArray();
        StringBuilder modifiedStr = new StringBuilder();
        for (char ch : characters) {
            if (ch != ' ' && modifiedStr.indexOf(String.valueOf(ch)) == -1) {
                modifiedStr.append(ch);
            }
        }
        return modifiedStr.toString();
    }


}
