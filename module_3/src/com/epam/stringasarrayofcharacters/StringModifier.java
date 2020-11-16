package com.epam.stringasarrayofcharacters;

public class StringModifier {

    // task 01
    public static String[] changeCamelCaseToSnakeCase(String[] variables) {
        String[] renamedVariables = new String[variables.length];
        for (int i = 0; i < variables.length; i++) {
            char[] charactersOfName = variables[i].toCharArray();
            renamedVariables[i] = "";
            for (char ch : charactersOfName) {
                if (Character.isUpperCase(ch)) {
                    renamedVariables[i] = renamedVariables[i].concat("_").concat(String.valueOf(ch));
                } else {
                    renamedVariables[i] = renamedVariables[i].concat(String.valueOf(ch));
                }
            }
        }
        return renamedVariables;
    }


    // task 02
    public static String changeSubstringInString(String str) {
        final int wordLength = 4;
        final char[] charactersOfStr = str.toCharArray();
        String editedStr = "";
        for (int i = 0; i <= charactersOfStr.length - wordLength; i++) {
            if (charactersOfStr[i] == 'w' && charactersOfStr[i + 1] == 'o' && charactersOfStr[i + 2] == 'r' &&
                    charactersOfStr[i + 3] == 'd') {
                editedStr = editedStr.concat("letter");
                i += 3;
            } else {
                editedStr = editedStr.concat(String.valueOf(charactersOfStr[i]));
            }
        }
        return editedStr;
    }

    // task 05
    public static String removeRedundantSpaces(String str) {
        final char[] charactersOfStr = str.toCharArray();
        String editedStr = "";
        for (int i = 0; i < charactersOfStr.length - 1; i++) {
            if (!(charactersOfStr[i] == ' ' && charactersOfStr[i + 1] == ' ') && !(charactersOfStr[i] == ' ' &&
                    editedStr.length() == 0)) {
                editedStr = editedStr.concat(String.valueOf(charactersOfStr[i]));
            }
        }
        if (charactersOfStr[charactersOfStr.length - 1] != ' ') {
            editedStr = editedStr.concat(String.valueOf(charactersOfStr[charactersOfStr.length - 1]));
        }
        return editedStr;
    }
}
