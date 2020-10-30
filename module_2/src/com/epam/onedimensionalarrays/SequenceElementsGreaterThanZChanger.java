package com.epam.onedimensionalarrays;

/**
 * Task #2:
 * The class for replacing with value "Z" all the elements
 * of the sequence of real numbers [a1, a2, ..., an]
 * those are greater than Z, with
 * counting the number of substitutions.
 */

public class SequenceElementsGreaterThanZChanger {
    public static int replaceELementsAndCountReplacements(double[] generatedSequence, double
            specifiedParameterZ) {
        int numberOfReplacements = 0;
        if (specifiedParameterZ < (Math.max(generatedSequence[0],
                generatedSequence[generatedSequence.length - 1]))) {
            for (int i = 0; i < generatedSequence.length; i++) {
                if (generatedSequence[i] > specifiedParameterZ) {
                    generatedSequence[i] = specifiedParameterZ;
                    numberOfReplacements++;
                }
            }
        } else {
            numberOfReplacements = -1;
            System.out.println("\nIncorrect value of Z!");
        }
        return numberOfReplacements;
    }
}
