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
}
