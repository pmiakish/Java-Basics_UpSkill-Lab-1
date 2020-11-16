package com.epam.stringasstringorstringbuilder;

public class TaskLauncher {

    // task 01
    private static final String STRING_INCLUDING_SPACES = "   This string   is intended     to count the maximum     " +
            "number of        consecutive  spaces  .";

    // tasks 02, 06, 07
    private static final String STRING_FOR_SUBSTR_REPLACING = "an apple and an orange";
    private static final String TEXT_TO_INSERT = "b";
    private static final String SPECIFIED_SUBSTR = "a";

    // task 03
    private static final String PALINDROME_OR_NOT = "Madam";

    // task 04
    private static final String DONOR_WORD = "информатика";
    private static final String SPECIFIED_WORD = "торт";

    // task 05
    private static final String STRING_TO_COUNT_CHAR_OCCURRENCES = "Java is a class-based, object-oriented " +
            "programming language that is designed to have as few implementation dependencies as possible";
    private static final char SPECIFIED_CHAR = 'a';

    // task 08
    private static final String WORDS_SEPARATED_BY_SPACES = "This string is intended to searching the longest word";

    public static void main(String[] args) {
        // task_01
        System.out.println("\n--- TASK 01 ---\nThe max number of consecutive spaces in the following string:\n\"" +
                STRING_INCLUDING_SPACES + "\"\nis " + StringAnalyzer.
                findMostAmountOfConsecutiveSpaces(STRING_INCLUDING_SPACES));

        // task_02
        System.out.println("\n--- TASK 02 ---\nThe original string is: \"" + STRING_FOR_SUBSTR_REPLACING + "\"\n" +
                "The modified string is: \"" + StringModifier.
                insertTextAfterSpecifiedSubstring(STRING_FOR_SUBSTR_REPLACING, TEXT_TO_INSERT, SPECIFIED_SUBSTR) +
                "\"");

        // task_03
        if (StringAnalyzer.checkIfWordIsPalindrome(PALINDROME_OR_NOT)) {
            System.out.println("\n--- TASK 03 ---\nThe string \"" + PALINDROME_OR_NOT + "\" is a palindrome");
        } else {
            System.out.println("\n--- TASK 03 ---\nThe string \"" + PALINDROME_OR_NOT + "\" isn't a palindrome");
        }

        // task_04
        String concatenatedWord = StringModifier.concatenateSpecifiedWordFromAnotherWord(DONOR_WORD, SPECIFIED_WORD);
        if (concatenatedWord.length() != 0) {
            System.out.println("\n--- TASK 04 ---\nThe word \"" + concatenatedWord + "\" was concatenated of " +
                    "characters containing in the word \"" + DONOR_WORD + "\".");
        } else {
            System.out.println("\n--- TASK 04 ---\nThe word \"" + SPECIFIED_WORD + "\" cannot be concatenated of " +
                    "characters containing in the word \"" + DONOR_WORD + "\"!");
        }

        // task_05
        System.out.println("\n--- TASK 05 ---\nThe character \"" + SPECIFIED_CHAR + "\" occurs in the string \"" +
                STRING_TO_COUNT_CHAR_OCCURRENCES + "\" " + StringAnalyzer.
                countOccurrencesOfCharacter(STRING_TO_COUNT_CHAR_OCCURRENCES, SPECIFIED_CHAR) + " times.");

        // task_06
        System.out.println("\n--- TASK 06 ---\nThe original string is: \"" + STRING_FOR_SUBSTR_REPLACING + "\"\nThe " +
                "modified string is: \"" + StringModifier.duplicateEachCharacter(STRING_FOR_SUBSTR_REPLACING) + "\"");

        // task_07
        System.out.println("\n--- TASK 07 ---\nThe original string is: \"" + STRING_FOR_SUBSTR_REPLACING + "\"\nThe " +
                "modified string is: \"" + StringModifier.
                removeSpacesAndRepeatingCharacters(STRING_FOR_SUBSTR_REPLACING) + "\"");

        // task_08
        System.out.println("\n--- TASK 08 ---\nThe longest word in the string: \"" + WORDS_SEPARATED_BY_SPACES + "\"\n" +
                "is: \"" + StringAnalyzer.findLongestWord(WORDS_SEPARATED_BY_SPACES) + "\"");

    }
}
