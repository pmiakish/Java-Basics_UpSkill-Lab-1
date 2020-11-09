package com.epam.stringasarrayofcharacters;

public class StringModifier {

    public static StringBuilder[] changeCamelCaseToSnakeCase(String[] variables) {
        StringBuilder[] renamedVariables = new StringBuilder[variables.length];
        for (int i = 0; i < variables.length; i++) {
            renamedVariables[i] = new StringBuilder();
            char[] charactersOfName = variables[i].toCharArray();
            for (char ch : charactersOfName) {
                if (Character.isUpperCase(ch)) {
                    renamedVariables[i].append('_').append(Character.toLowerCase(ch));
                } else {
                    renamedVariables[i].append(ch);
                }
            }
        }
        return renamedVariables;
    }

    public static String changeSubstringInString(String str) {
        String strWithReplacedSubstr = "";
        return  strWithReplacedSubstr = str.replace("word", "letter");
    }

}
