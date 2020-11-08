package com.epam.decompositionusingmethods;

import java.util.ArrayList;

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

    public static int[] splitNumberIntoDigits(int number) {
        int[] digits = new int[String.valueOf(number).length()];
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int[] splitNumberIntoDigits(long number) {
        int[] digits = new int[String.valueOf(number).length()];
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i] = (int) number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int compareAmountOfDigitsInTwoNumbers(int firstNumber, int secondNumber) {
        int result;
        int firstNumberLength = String.valueOf(firstNumber).length();
        int secondNumberLength = String.valueOf(secondNumber).length();
        if (firstNumberLength > secondNumberLength) {
            result = 0;
        } else if (firstNumberLength < secondNumberLength) {
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }

    public static ArrayList<Integer> findNumbersEqualsToSumOfDigitsOfNumberKAndLessThanNumberN(int k, int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int minNumber = (int) (k % 9 * Math.pow(10.0, k / 9)) + (int) (Math.pow(10.0, k / 9)) - 1;
        if (k > 0 && n >= minNumber) {
            for (int i = n; i >= minNumber; i--) {
                int[] digits = splitNumberIntoDigits(i);
                int sum = 0;
                for (int digit : digits) {
                    sum += digit;
                }
                if (sum == k) {
                    numbers.add(i);
                }
            }
        }
        return numbers;
    }

    public static StringBuilder findTwinPrimeNumbers(int firstNumber, int lastNumber) {
        StringBuilder twinPrimes = new StringBuilder();
        final int specifiedFactor = 2;
        if (firstNumber > 2 && lastNumber == specifiedFactor * firstNumber) {
            ArrayList<Integer> primeNumbers = findPrimeNumbers(firstNumber, lastNumber);
            if (primeNumbers.size() != 0) {
                for (int i = 1; i < primeNumbers.size(); i++) {
                    if (primeNumbers.get(i - 1) + 2 == primeNumbers.get(i)) {
                        twinPrimes.append("[").append(primeNumbers.get(i - 1)).append(", ").append(primeNumbers.get(i)).
                                append("] ");
                    }
                }
            }
        }
        return twinPrimes;
    }

    private static ArrayList<Integer> findPrimeNumbers(int firstNumber, int lastNumber) {
        final int minDivisorForPrimeNumbers = 2;
        final int firstPrimeNumber = 2;
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        if (firstNumber >= firstPrimeNumber && lastNumber > firstNumber) {
            for (int i = firstPrimeNumber; i <= lastNumber; i++) {
                boolean isCompositeNumber = false;
                for (int divisor = minDivisorForPrimeNumbers; divisor <= Math.round(Math.sqrt(i)); divisor++) {
                    if (i % divisor == 0) {
                        isCompositeNumber = true;
                        break;
                    }
                }
                if (!isCompositeNumber) {
                    primeNumbers.add(i);
                }
            }
        }
        return primeNumbers;
    }

    public static StringBuilder findArmstrongNumbers(int firstNumber, int lastNumber) {
        StringBuilder armstrongNumbers = new StringBuilder();
        if (firstNumber > 0 && lastNumber > firstNumber) {
            for (int i = firstNumber; i <= lastNumber; i++) {
                int[] digits = splitNumberIntoDigits(i);
                int sumOfPow = 0;
                for (int digit : digits) {
                    sumOfPow += (int) Math.pow(digit, digits.length);
                }
                if (i == sumOfPow) {
                    armstrongNumbers.append("[").append(i).append("] ");
                }
            }
        }
        return armstrongNumbers;
    }

    public static StringBuilder findNumbersWithIncreasingDigitSequence(int digitCapacity) {
        StringBuilder numbersWithIncreasingDigitSequence = new StringBuilder();
        if (digitCapacity > 1) {
            for (int i = (int) (Math.pow(10.0, digitCapacity - 1.0)); i < (int) (Math.pow(10.0, digitCapacity)); i++) {
                int[] digits = splitNumberIntoDigits(i);
                boolean isIncreasingSequence = true;
                for (int j = 1; j < digits.length; j++) {
                    if (digits[j] != digits[j - 1] + 1) {
                        isIncreasingSequence = false;
                        break;
                    }
                }
                if (isIncreasingSequence) {
                    numbersWithIncreasingDigitSequence.append("[").append(i).append("] ");
                }
            }
        }
        return numbersWithIncreasingDigitSequence;
    }

    public static long calculateSumOfNumbersWithOddDigits(int digitCapacity) {
        long sum = -1;
        if (digitCapacity > 1) {
            sum = 0;
            for (int i = (int) (Math.pow(10.0, digitCapacity - 1.0)); i < (int) (Math.pow(10.0, digitCapacity)); i++) {
                int[] digits = splitNumberIntoDigits(i);
                boolean isNumberWithOddDigits = true;
                for (int digit : digits) {
                    if (digit % 2 == 0) {
                        isNumberWithOddDigits = false;
                        break;
                    }
                }
                if (isNumberWithOddDigits) {
                    sum += i;
                }
            }
        }
        return sum;
    }

    public static int countSubtractionsSumOfDigitsFromNumber(int number) {
        int counterOfSubtractions = -1;
        if (number > 1) {
            counterOfSubtractions = 0;
            while (number > 0) {
                int[] digits = splitNumberIntoDigits(number);
                for (int digit : digits) {
                    number -= digit;
                }
                counterOfSubtractions++;
            }
        }
        return counterOfSubtractions;
    }

}
