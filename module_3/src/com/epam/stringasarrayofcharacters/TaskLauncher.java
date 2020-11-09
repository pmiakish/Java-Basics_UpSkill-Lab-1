package com.epam.stringasarrayofcharacters;

import java.util.Arrays;

public class TaskLauncher {

    // task 01
    private static final String[] NAMES_OF_VARIABLES =
            {"camelCase", "bestNameOfVariable", "stringVariable", "itemOfArray", "lastName"};

    // task 02
    private static final String TEXT_FOR_REPLACING = "For one thing, dictionaries are limited by space; for another, " +
            "dictionaries count words in different ways and therefore differ in the number of entries they have. " +
            "Dictionaries include headwords (also called lemmas) that a lot of people consider to be, " +
            "authoritatively, words, but these also include prefixes, suffixes, combining forms, and other word " +
            "forms and elements—many of which we don’t necessarily think of or categorize as words.";

    public static void main(String[] args) {
        // task 01
        StringBuilder[] renamedVariables = StringModifier.changeCamelCaseToSnakeCase(NAMES_OF_VARIABLES);
        System.out.println("\n--- TASK 01 ---\nThe camelCase names: " + Arrays.toString(NAMES_OF_VARIABLES) + "\n" +
                "The snake_case names: " + Arrays.toString(renamedVariables));

        // task 02
        String strWithReplacedSubstr = StringModifier.changeSubstringInString(TEXT_FOR_REPLACING);
        System.out.println("\n--- TASK 02 ---\nThe original text:\n" + TEXT_FOR_REPLACING + "\n" +
                "The modified text (substring 'word' was replaced by 'letter'):\n" + strWithReplacedSubstr);
    }
}
