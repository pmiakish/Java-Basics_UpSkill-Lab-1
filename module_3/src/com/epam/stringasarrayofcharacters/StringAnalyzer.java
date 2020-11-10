package com.epam.stringasarrayofcharacters;

public class StringAnalyzer {

    public static int countAmountOfDigits(String str) {
        int counterOfDigits = 0;
        char[] characters = str.toCharArray();
        for (char ch : characters) {
            if ((int) ch > 47 && (int) ch < 58) {
                counterOfDigits++;
            }
        }
        return counterOfDigits;
    }

    public static int countAmountOfNumbers(String str) {
        String strWithoutSeparators = str.replace(".", "").replace(",", "");
        char[] characters = strWithoutSeparators.toCharArray();
        int counterOfNumbers = 0;
        boolean foundNumber = false;
        for (char ch : characters) {
            if (foundNumber && !((int) ch > 47 && (int) ch < 58)) {
                foundNumber = false;
            }
            else if (!foundNumber && (int) ch > 47 && (int) ch < 58) {
                foundNumber = true;
                counterOfNumbers++;
            }
        }
        return counterOfNumbers;
    }

}
