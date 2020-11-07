package com.epam.decompositionusingmethods;

public class NumbersAnalyzer {

    public static int findGreatestCommonDivisor(int firstNumber, int secondNumber) {
        int divisor = -1;
        if (firstNumber > 0 && secondNumber > 0) {
            divisor = Math.min(firstNumber, secondNumber);
            int dividend = Math.max(firstNumber, secondNumber);
            int remainder;
            while (dividend % divisor != 0) {
                remainder = dividend % divisor;
                dividend = divisor;
                divisor = remainder;
            }
        }
        return divisor;
    }

    public static int findGreatestCommonDivisor(int firstNumber, int secondNumber, int thirdNumber) {
        int divisor = -1;
        if (firstNumber > 0 && secondNumber > 0 && thirdNumber > 0) {
            divisor = findGreatestCommonDivisor(findGreatestCommonDivisor(firstNumber, secondNumber), thirdNumber);
            }
        return divisor;
    }

    public static int findGreatestCommonDivisor(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {
        int divisor = -1;
        if (firstNumber > 0 && secondNumber > 0 && thirdNumber > 0 && fourthNumber > 0) {
            final int[] otherNumbers = new int[]{thirdNumber, fourthNumber};
            divisor = findGreatestCommonDivisor(firstNumber, secondNumber);
            for (int number : otherNumbers) {
                divisor = findGreatestCommonDivisor(divisor, number);
            }
        }
        return divisor;
    }

    public static int findLeastCommonMultiple(int firstNumber, int secondNumber) {
        int multiple = -1;
        if (firstNumber > 0 && secondNumber > 0) {
            multiple = (firstNumber * secondNumber) / findGreatestCommonDivisor(firstNumber, secondNumber);
        }
        return multiple;
    }

    public static int findSecondLargestNumber(int[] numbers) {
        int largestNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largestNumber) {
                largestNumber = numbers[i];
            }
        }
        int secondLargestNumber = Integer.MIN_VALUE;
        for (int currentNumber : numbers) {
            if (currentNumber < largestNumber && currentNumber > secondLargestNumber) {
                secondLargestNumber = currentNumber;
            }
        }
        return secondLargestNumber;
    }

    public static int checkIfNumbersAreCoprime(int firstNumber, int secondNumber, int thirdNumber) {
        int result = -1;
        if (findGreatestCommonDivisor(firstNumber, secondNumber, thirdNumber) == 1) {
            result = 1;
        } else if (findGreatestCommonDivisor(firstNumber, secondNumber, thirdNumber) > 1) {
            result = 0;
        }
        return result;
    }

}
