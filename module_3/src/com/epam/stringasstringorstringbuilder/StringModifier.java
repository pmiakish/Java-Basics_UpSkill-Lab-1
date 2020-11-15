package com.epam.stringasstringorstringbuilder;

public class StringModifier {

    // task_02
    public static String insertTextAfterSpecifiedSubstring(String str, String textToInsert, String specifiedSubstr) {
        String resultString = "";
        if (str.contains(specifiedSubstr)) {
            resultString = str.replace(specifiedSubstr, specifiedSubstr + textToInsert);
        }
        return resultString;
    }

    // task_04
    public static String concatenateSpecifiedWordFromAnotherWord(String donorWord, String specifiedWord) {
        String resultStr = "";
        boolean thereAreNotAllCharacters = false;
        int index;
        for (int i = 0; i < specifiedWord.length(); i++) {
            index = donorWord.indexOf(specifiedWord.charAt(i));
            if (index != -1) {
                resultStr = resultStr.concat(String.valueOf(donorWord.charAt(index)));
            } else {
                thereAreNotAllCharacters = true;
                break;
            }
        }
        return (thereAreNotAllCharacters) ? "" : resultStr;
    }

    // task_06
    public static String duplicateEachCharacter(String str) {
        char[] characters = str.toCharArray();
        char[] duplicateCharacters = new char[characters.length * 2];
        for (int i = 0; i < duplicateCharacters.length; i += 2) {
            duplicateCharacters[i] = characters[i / 2];
            duplicateCharacters[i + 1] = characters[i / 2];
        }
        return new String(duplicateCharacters);
    }


}
