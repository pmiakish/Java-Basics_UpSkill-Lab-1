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
        int secondLargestNumber = Integer.MIN_VALUE;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largestNumber) {
                secondLargestNumber = largestNumber;
                largestNumber = numbers[i];
            } else if (numbers[i] > secondLargestNumber) {
                secondLargestNumber = numbers[i];
            }
        }
        return secondLargestNumber;
    }

    public static long findSumOfOddNumbersFactorials(int lastNumber) {
        long sum = -1;
        if (lastNumber > 0) {
            sum = 0;
            for (int i = 1; i <= lastNumber; i += 2) {
                sum += calculateFactorialOfNumber(i);
            }
        }
        return sum;
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

    public static int findSumOfThreeConsecutiveItemsOfArray(int[] array, int firstItem, int lastItem) {
        final int numberOfItems = 3;
        int sum = Integer.MIN_VALUE;
        if (firstItem >= 0 && lastItem < array.length && lastItem - firstItem == numberOfItems - 1) {
            sum = 0;
            for (int i = firstItem; i <= lastItem; i++) {
                sum += array[i];
            }
        }
        return sum;
    }

}
