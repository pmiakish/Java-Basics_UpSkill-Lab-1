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

    // task_024
    public static String concatenateSpecifiedWordFromAnotherWord(String donorWord, String specifiedWord) {
        String resultString = "";
        boolean thereAreNotAllCharacters = false;
        int index;
        for (int i = 0; i < specifiedWord.length(); i++) {
            index = donorWord.indexOf(specifiedWord.charAt(i));
            if (index != -1) {
                resultString = resultString.concat(String.valueOf(donorWord.charAt(index)));
            } else {
                thereAreNotAllCharacters = true;
                break;
            }
        }
        return (thereAreNotAllCharacters) ? "" : resultString;
    }
}
