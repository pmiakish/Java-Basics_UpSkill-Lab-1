package com.epam.aggregationandcomposition.service;

import com.epam.aggregationandcomposition.entity.account.Account;
import com.epam.aggregationandcomposition.entity.account.Customer;
import com.epam.aggregationandcomposition.exceptions.AccountLogicalException;
import com.epam.aggregationandcomposition.exceptions.CustomerLogicalException;
import com.epam.aggregationandcomposition.util.init.RandomNumberGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class AccountController {

    private static final String CUSTOMER_NAME = "Anikeenko A.A.";
    private static final int NUMBER_OF_ACCOUNTS = 5;
    private static final int NUMBER_OF_BLOCKED_ACCOUNTS = 2;
    private static final double MIN_BALANCE = -5000.0;
    private static final double MAX_BALANCE = 5000.0;
    private static final long ACCOUNT_NUMBER_FOR_SEARCHING = 1572501004L;

    public static void main(String[] args) {
        try {
            List<Account> accounts = new ArrayList<>();
            for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++) {
                accounts.add(new Account(BigDecimal.valueOf(RandomNumberGenerator.generate(MIN_BALANCE, MAX_BALANCE))));
            }
            for (int i = 0; i < NUMBER_OF_BLOCKED_ACCOUNTS; i++) {
                int randomNumber = RandomNumberGenerator.generate(0, accounts.size() - 1);
                if (!accounts.get(randomNumber).isBlocked()) {
                    accounts.get(randomNumber).setBlocked(true);
                } else {
                    i--;
                }
            }

            Customer customer = new Customer(CUSTOMER_NAME, accounts);
            System.out.println("The customer info:\n" + customer);
            System.out.println("The common balance is: " + customer.getCommonBalance());
            System.out.println("The common positive balance is: " + customer.getCommonPositiveBalance());
            System.out.println("The common negative balance is: " + customer.getCommonNegativeBalance());
            System.out.println("\nSorting of accounts by balance:");
            customer.getAccounts().sort(Comparator.comparing(Account::getBalance));
            System.out.println(customer);
            System.out.println("\nSorting of accounts by status:");
            customer.getAccounts().sort(Comparator.comparing(Account::isBlocked));
            System.out.println(customer);
            System.out.println("\nSorting of accounts by number:");
            customer.getAccounts().sort(Comparator.comparing(Account::getNumber));
            System.out.println(customer);
            System.out.println("\nSearching for account with number '" + ACCOUNT_NUMBER_FOR_SEARCHING + "':");
            Account foundedAccount = customer.findAccountByNumber(ACCOUNT_NUMBER_FOR_SEARCHING);
            System.out.println(Objects.requireNonNullElse(foundedAccount, "The account with specified number" +
                    " is not found!"));

        } catch (CustomerLogicalException | AccountLogicalException e) {
            e.printStackTrace();
        }

    }

}
