package com.epam.stringasstringorstringbuilder;

public class TaskLauncher {

    // task_01
    private static final String STRING_INCLUDING_SPACES = "   This string   is intended     to count the maximum     " +
            "number of        consecutive  spaces  .";

    // task_02
    private static final String STRING_FOR_SUBSTR_REPLACING = "an apple and an orange";
    private static final String TEXT_TO_INSERT = "b";
    private static final String SPECIFIED_SUBSTR = "a";

    // task_03
    private static final String PALINDROME_OR_NOT = "Madam";

    // task_04
    private static final String DONOR_WORD = "информатика";
    private static final String SPECIFIED_WORD = "торт";

    public static void main(String[] args) {
        // task_01
        int amountOfSpaces = StringAnalyzer.findMostAmountOfConsecutiveSpaces(STRING_INCLUDING_SPACES);
        if (amountOfSpaces != -1) {
            System.out.println("\n--- TASK 01 ---\nThe max number of consecutive spaces in the following string:\n\"" +
                    STRING_INCLUDING_SPACES + "\"\nis " + amountOfSpaces);
        } else {
            System.out.println("\n--- TASK 01 ---\nThe string:\n\"" +
                    STRING_INCLUDING_SPACES + "\"\ndoesn't contain spaces!");
        }

        // task_02
        String strWithReplacedSubstrings = StringModifier.insertTextAfterSpecifiedSubstring(STRING_FOR_SUBSTR_REPLACING,
               TEXT_TO_INSERT, SPECIFIED_SUBSTR);
        if (strWithReplacedSubstrings.length() != 0) {
            System.out.println("\n--- TASK 02 ---\nThe original string is: \"" + STRING_FOR_SUBSTR_REPLACING + "\"\n" +
                    "The modified string is: \"" + strWithReplacedSubstrings + "\"");
        } else {
            System.out.println("\n--- TASK 02 ---\nThe string:\n\"" + STRING_FOR_SUBSTR_REPLACING +
                    "\"\ndoesn't contain the specified substring!");
        }

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

    }
}
