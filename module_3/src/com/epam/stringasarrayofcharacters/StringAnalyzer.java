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

}
