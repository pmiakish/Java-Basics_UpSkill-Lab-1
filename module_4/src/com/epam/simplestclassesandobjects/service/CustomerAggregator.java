package com.epam.simplestclassesandobjects.service;

import com.epam.simplestclassesandobjects.entity.Customer;

import java.util.ArrayList;

public class CustomerAggregator {

    private static final String[] FIRST_NAMES = {"Alexandr", "Ivan", "Denis", "Igor", "Anton", "Eduard", "Egor",
            "Vladimir", "Leonid", "Robert", "Maxim", "Petr", "Ruslan", "Pavel", "Oleg", "Artur"};
    private static final String[] PATRONYMIC_NAMES = {"Alexandrovich", "Ivanovich", "Denisovich", "Igorevich",
            "Antonovich", "Eduardovich", "Egorovich", "Vladimirovich", "Leonidovich", "Robertovich", "Maximovich",
            "Petrovich", "Ruslanovich", "Pavlovich", "Olegovich", "Arturovich"};
    private static final String[] SURNAMES = {"Keyko", "Ivanovov", "Pavlovky", "Zhuk", "Bartosh", "Glebov", "Poluyan",
            "Olehnovich", "Zhurko", "Aplevich", "Leonenko", "Ambrushkevich", "Kuhta", "Kozlovich", "Komarec", "Byk"};
    private static final long CARD_NUMBER_BASE = 5106211010250000L;
    private static final long ACCOUNT_NUMBER_BASE = 3654750000L;
    private static final long MIN_NUMBER_POSTFIX_ADDEND = 1L;
    private static final long MAX_NUMBER_POSTFIX_ADDEND = 9999L;
    private static final int NUMBER_OF_POSTFIX_DIGITS = 4;

    public static Customer[] generateCustomerArray(int numberOfCustomers) {
        Customer[] customers = (numberOfCustomers > 0) ? new Customer[numberOfCustomers] : null;
        for (int i = 0; i < numberOfCustomers; i++) {
            String randomFirstName = FIRST_NAMES[(int) generateRandomNumber(0, FIRST_NAMES.length - 1)];
            String randomPatronymicName = PATRONYMIC_NAMES[(int) generateRandomNumber(0, PATRONYMIC_NAMES.length - 1)];
            String randomSurname = SURNAMES[(int) generateRandomNumber(0, SURNAMES.length - 1)];
            long randomCardNumber = CARD_NUMBER_BASE + generateRandomNumber(MIN_NUMBER_POSTFIX_ADDEND,
                    MAX_NUMBER_POSTFIX_ADDEND);
            long randomAccountNumber = ACCOUNT_NUMBER_BASE + generateRandomNumber(MIN_NUMBER_POSTFIX_ADDEND,
                    MAX_NUMBER_POSTFIX_ADDEND);
            try {
                customers[i] = new Customer(randomFirstName, randomPatronymicName, randomSurname, randomCardNumber,
                        randomAccountNumber);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                customers = null;
                break;
            }
        }
        return customers;
    }

    public static void printCustomers(Customer[] customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public static ArrayList<Customer> findCustomersWithSpecifiedCardNumberPostfix(Customer[] customers, String
            minPostfix, String maxPostfix) throws NumberFormatException {
        ArrayList<Customer> customersWithSpecifiedCardNumberPostfix = new ArrayList<Customer>();
        for (Customer customer : customers) {
            long postfixOfCardNumber = customer.getCardNumber() % (long) Math.pow(10, NUMBER_OF_POSTFIX_DIGITS);
            if (postfixOfCardNumber >= Long.parseLong(minPostfix) && postfixOfCardNumber <= Long.
                    parseLong(maxPostfix)) {
                customersWithSpecifiedCardNumberPostfix.add(customer);
            }
        }
        return customersWithSpecifiedCardNumberPostfix;
    }

    private static long generateRandomNumber(long minValue, long maxValue) {
        return (long) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
}
