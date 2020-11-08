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

    public static long findSumOfOddNumbersFactorials(int firstNumber, int secondNumber) {
        long sum = -1;
        int[] oddNumbers = findOddNumbersInSpecifiedRange(firstNumber, secondNumber);
        if (oddNumbers != null) {
            sum = 0;
            for (int number : oddNumbers) {
                sum += calculateFactorialOfNumber(number);
            }
        }
        return sum;
    }

    private static int[] findOddNumbersInSpecifiedRange(int minValue, int maxValue) {
        int[] oddNumbers = null;
        if (maxValue > minValue) {
            int amountOfNumbersInSpecifiedRange = maxValue - minValue + 1;
            if (minValue % 2 == 0 && amountOfNumbersInSpecifiedRange % 2 != 0) {
                oddNumbers = new int[amountOfNumbersInSpecifiedRange / 2];
            } else {
                oddNumbers = new int[(amountOfNumbersInSpecifiedRange + 1) / 2];
            }
            int firstOddNumber;
            if (minValue % 2 == 0) {
                firstOddNumber = minValue + 1;
            } else {
                firstOddNumber = minValue;
            }
            for (int i = 0; i < oddNumbers.length; i++) {
                oddNumbers[i] = firstOddNumber;
                firstOddNumber += 2;
            }
        }
        return oddNumbers;
    }

    private static long calculateFactorialOfNumber(int naturalNumber) {
        long factorial = -1;
        if (naturalNumber >= 1) {
            factorial = 1;
            for (int i = 2; i <= naturalNumber; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }


}
