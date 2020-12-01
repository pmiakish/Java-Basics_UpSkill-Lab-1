package com.epam.simplestclassesandobjects;

import java.util.Comparator;

public class CustomerByNameComparator implements Comparator<Customer> {
    public int compare(Customer customer1, Customer customer2) {
        final int comparisonBySurname = customer1.getSurname().compareToIgnoreCase(customer2.getSurname());
        if (comparisonBySurname != 0) {
            return comparisonBySurname;
        }
        final int comparisonByFirstName = customer1.getFirstName().compareToIgnoreCase(customer2.getFirstName());
        if (comparisonByFirstName != 0) {
            return comparisonByFirstName;
        } else {
            return customer1.getPatronymicName().compareToIgnoreCase(customer2.getPatronymicName());
        }
    }
}
