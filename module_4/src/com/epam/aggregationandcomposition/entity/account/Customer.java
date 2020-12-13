package com.epam.aggregationandcomposition.entity.account;

import com.epam.aggregationandcomposition.exceptions.CustomerLogicalException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {

    private String name;
    private List<Account> accounts;

    public Customer(String name, List<Account> accounts) throws CustomerLogicalException {
        if (isCorrectName(name) && accounts != null && accounts.size() != 0) {
            this.name = name;
            this.accounts = accounts;
        } else {
            throw new CustomerLogicalException("Incorrect parameters. Can't create an customer!");
        }
    }

    public double getCommonBalance() {
        return accounts.stream().mapToDouble(Account::getBalance).sum();
    }

    public double getCommonPositiveBalance() {
        return accounts.stream().filter(account -> account.getBalance() > 0).mapToDouble(Account::getBalance).sum();
    }

    public double getCommonNegativeBalance() {
        return accounts.stream().filter(account -> account.getBalance() < 0).mapToDouble(Account::getBalance).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws CustomerLogicalException {
        if (isCorrectName(name)) {
            this.name = name;
        } else {
            throw new CustomerLogicalException("Incorrect parameter. Can't change the customer name!");
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) throws CustomerLogicalException {
        if (accounts != null && accounts.size() != 0) {
            this.accounts = accounts;
        } else {
            throw new CustomerLogicalException("Incorrect parameter. Can't change the accounts of the customer!");
        }
    }

    private boolean isCorrectName(String name) {
        return (name != null &&
                name.length() != 0 &&
                Pattern.compile("^[A-Z]+[A-Za-z\\. -]+$").matcher(name).matches());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer other = (Customer) o;
        return Objects.equals(name, other.name) &&
                Objects.equals(accounts, other.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accounts);
    }

    @Override
    public String toString() {
        return "Customer {" +
                "name: " + name +
                "; accounts: " + accounts +
                "}";
    }

}
