package com.epam.onedimensionalarrays;

/**
 * Task #2:
 * The class for replacing with value "Z" all the elements
 * of the sequence of real numbers [a1, a2, ..., an]
 * those are greater than Z, with
 * counting the number of substitutions.
 */

public class SequenceElementsGreaterThanZChanger {
    public static double[] replaceElements(double[] generatedSequence, double specifiedParameterZ) {
        if (specifiedParameterZ < (Math.max(generatedSequence[0], generatedSequence[generatedSequence.length - 1]))) {
            int numberOfReplacements = 0;
            for (int i = 0; i < generatedSequence.length; i++) {
                if (generatedSequence[i] > specifiedParameterZ) {
                    generatedSequence[i] = specifiedParameterZ;
                    numberOfReplacements++;
                }
            }
            System.out.println("\nNumber of replacements is " + numberOfReplacements);
        } else {
            generatedSequence = null;
            System.out.println("\nIncorrect value of Z!");
        }
        return generatedSequence;
    }
}
