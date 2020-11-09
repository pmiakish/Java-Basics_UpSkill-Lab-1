package com.epam.stringasarrayofcharacters;

import java.util.Arrays;

public class TaskLauncher {

    // task 01
    private static final String[] NAMES_OF_VARIABLES =
            {"camelCase", "bestNameOfVariable", "stringVariable", "itemOfArray", "lastName"};

    public static void main(String[] args) {
        // task 01
        StringBuilder[] renamedVariables = StringModifier.changeCamelCaseToSnakeCase(NAMES_OF_VARIABLES);
        System.out.println("\n--- TASK 01 ---\nThe camelCase names: " + Arrays.toString(NAMES_OF_VARIABLES) + "\n" +
                "The snake_case names: " + Arrays.toString(renamedVariables));
    }
}
