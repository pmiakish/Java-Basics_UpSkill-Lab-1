package com.epam.simplestclassesandobjects.entity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements Comparable<Customer>{

    private final int id;
    private static int counterId = 1;
    private String firstName;
    private String patronymicName;
    private String surname;
    private long cardNumber;
    private long accountNumber;

    public Customer(String firstName, String patronymicName, String surname, long cardNumber, long accountNumber)
            throws IllegalArgumentException {
        if (isCorrectName(firstName, patronymicName, surname) && isCorrectCardNumber(cardNumber) &&
                isCorrectAccountNumber(accountNumber)) {
            id = counterId++;
            this.firstName = firstName;
            this.patronymicName = patronymicName;
            this.surname = surname;
            this.cardNumber = cardNumber;
            this.accountNumber = accountNumber;
        } else {
            throw new IllegalArgumentException("Wrong values of customer fields! The customer wasn't create!");
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (isCorrectName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Incorrect customer name! Can't change the field!");
        }
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        if (isCorrectName(patronymicName)) {
            this.patronymicName = patronymicName;
        } else {
            throw new IllegalArgumentException("Incorrect customer name! Can't change the field!");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (isCorrectName(surname)) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Incorrect customer name! Can't change the field!");
        }
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        if (isCorrectCardNumber(cardNumber)) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Incorrect card number! Can't change the field!");
        }
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        if (isCorrectAccountNumber(accountNumber)) {
            this.accountNumber = accountNumber;
        } else {
            throw new IllegalArgumentException("Incorrect account number! Can't change the field!");
        }
    }

    // checking of arguments
    private boolean isCorrectName(String ...names) {
        Pattern namePattern = Pattern.compile("[A-Za-z-]+");
        for (String name : names) {
            if (name == null) {
                return false;
            } else {
                Matcher nameMatcher = namePattern.matcher(name);
                if (!nameMatcher.matches()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCorrectCardNumber(long cardNumber) {
        Pattern cardPattern = Pattern.compile("^[1-9]\\d{15}$");
        Matcher cardMatcher = cardPattern.matcher(String.valueOf(cardNumber));
        return cardMatcher.matches();
    }

    private boolean isCorrectAccountNumber(long accountNumber) {
        Pattern accountPattern = Pattern.compile("^[1-9]\\d{9}$");
        Matcher accountMatcher = accountPattern.matcher(String.valueOf(accountNumber));
        return accountMatcher.matches();
    }

    @Override
    public String toString() {
        return "Customer [" +
                "id: " + id +
                "; first name: " + firstName +
                "; patronymic name: " + patronymicName +
                "; surname: " + surname +
                "; card number: " + cardNumber +
                "; account number: " + accountNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return id == other.id &&
                cardNumber == other.cardNumber &&
                accountNumber == other.accountNumber &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(patronymicName, other.patronymicName) &&
                Objects.equals(surname, other.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, patronymicName, surname, cardNumber, accountNumber);
    }

    @Override
    public int compareTo(Customer other) {
        final int comparisonBySurname = this.getSurname().compareToIgnoreCase(other.getSurname());
        if (comparisonBySurname != 0) {
            return comparisonBySurname;
        }
        final int comparisonByFirstName = this.getFirstName().compareToIgnoreCase(other.getFirstName());
        if (comparisonByFirstName != 0) {
            return comparisonByFirstName;
        } else {
            return this.getPatronymicName().compareToIgnoreCase(other.getPatronymicName());
        }
    }

}
