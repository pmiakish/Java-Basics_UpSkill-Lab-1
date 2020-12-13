package com.epam.aggregationandcomposition.entity.account;

import java.util.Objects;

public class Account {

    private static int counterId = 0;
    private static long accountNumberPrefix = 1572501000L;

    private final long number;
    private boolean isUnblocked = true;
    private double balance = 0.0;

    public Account() {
        this.number = accountNumberPrefix + counterId++;
    }

    public Account(double balance) {
        this();
        this.balance = balance;
    }

    public Account(boolean isUnblocked, double balance) {
        this();
        this.isUnblocked = isUnblocked;
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    public boolean isUnblocked() {
        return isUnblocked;
    }

    public void setUnblocked(boolean unblocked) {
        isUnblocked = unblocked;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        String blocking = (isUnblocked) ? "unblocked" : "blocked";
        return "(account number: " + number +
                ", status: " + blocking +
                ", balance: " + balance + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account other = (Account) o;
        return number == other.number &&
                isUnblocked == other.isUnblocked &&
                Double.compare(other.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, isUnblocked, balance);
    }
}
