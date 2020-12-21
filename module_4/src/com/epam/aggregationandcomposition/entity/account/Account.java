package com.epam.aggregationandcomposition.entity.account;

import com.epam.aggregationandcomposition.exceptions.AccountLogicalException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Account {

    private static int counterId = 0;
    private final static long accountNumberPrefix = 1572501000L;

    private final long number;
    private boolean isBlocked = false;
    private BigDecimal balance = BigDecimal.ZERO;

    public Account() {
        this.number = accountNumberPrefix + counterId++;
    }

    public Account(BigDecimal balance) throws AccountLogicalException {
        this();
        if (balance != null) {
            this.balance = balance;
        } else {
            throw new AccountLogicalException("Incorrect parameter. Can't create an account!");
        }
    }

    public Account(boolean isBlocked, BigDecimal balance) throws AccountLogicalException {
        this();
        if (balance != null) {
            this.isBlocked = isBlocked;
            this.balance = balance;
        } else {
            throw new AccountLogicalException("Incorrect parameter. Can't create an account!");
        }
    }

    public long getNumber() {
        return number;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        String blocking = (isBlocked) ? "blocked" : "unblocked";
        return "(account number: " + number +
                ", status: " + blocking +
                ", balance: " + balance.setScale(2, RoundingMode.HALF_UP) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account other = (Account) o;
        return number == other.number &&
                isBlocked == other.isBlocked &&
                Objects.equals(balance, other.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, isBlocked, balance);
    }
}