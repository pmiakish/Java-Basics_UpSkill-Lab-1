package com.epam.stringasarrayofcharacters;

import java.util.Arrays;

public class TaskLauncher {
    public static void main(String[] args) {
        // task 01
        String[] namesOfVariables = {"camelCase", "bestNameOfVariable", "stringVariable", "itemOfArray", "lastName"};
        StringBuilder[] renamedVariables = StringModifier.changeCamelCaseToSnakeCase(namesOfVariables);
        System.out.println("\n--- TASK 01 ---\nThe camelCase names: " + Arrays.toString(namesOfVariables) + "\n" +
                "The snake_case names: " + Arrays.toString(renamedVariables));
    }
}
