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

    // tasks 03, 04
    private static final String TEXT_WITH_DIGITS = "Globally the number of internet users increased from only 413 " +
            "million in 2000 to over 3.4 billion in 2016. The one billion barrier was crossed in 2005. Every day " +
            "over the past five years, an average of 640,000 people went online for the first time.";

    public static void main(String[] args) {
        // task 01
        StringBuilder[] renamedVariables = StringModifier.changeCamelCaseToSnakeCase(NAMES_OF_VARIABLES);
        System.out.println("\n--- TASK 01 ---\nThe camelCase names: " + Arrays.toString(NAMES_OF_VARIABLES) + "\n" +
                "The snake_case names: " + Arrays.toString(renamedVariables));

        // task 02
        String strWithReplacedSubstr = StringModifier.changeSubstringInString(TEXT_FOR_REPLACING);
        System.out.println("\n--- TASK 02 ---\nThe original text:\n" + TEXT_FOR_REPLACING + "\n" +
                "The modified text (substring 'word' was replaced by 'letter'):\n" + strWithReplacedSubstr);

        // task 03
        System.out.println("\n--- TASK 03 ---\nThe number of digits in the following string:\n\"" + TEXT_WITH_DIGITS +
                "\"\nis " + StringAnalyzer.countAmountOfDigits(TEXT_WITH_DIGITS));

        // task 04
        System.out.println("\n--- TASK 04 ---\nThe amount of numbers in the following string:\n\"" + TEXT_WITH_DIGITS +
                "\"\nis " + StringAnalyzer.countAmountOfNumbers(TEXT_WITH_DIGITS));
    }
}
