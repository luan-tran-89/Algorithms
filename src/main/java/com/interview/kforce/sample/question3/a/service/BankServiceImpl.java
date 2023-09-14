package com.interview.kforce.sample.question3.a.service;

import com.interview.kforce.sample.question3.a.model.Account;

import java.util.List;

/**
 * @author gasieugru
 */
public class BankServiceImpl implements BankService {
    List<Account> accounts;

    public BankServiceImpl(List<Account> accounts) {
        this.accounts = accounts;
    }

    private Account getAccount(int accountId) throws Exception {
        if (accountId < 0) {
            throw new IllegalArgumentException("Invalid accountId.");
        }
        Account account = this.accounts.stream()
                .filter(acc -> acc.getAccountId() == accountId)
                .findFirst()
                .orElseThrow(() -> new Exception("Account not found: " + accountId));
        return account;
    }

    @Override
    public double getBalance(int accountId) throws Exception {
        Account account = this.getAccount(accountId);
        return account.getBalance();
    }

    @Override
    public void withdraw(int accountId, double amount) throws Exception {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount.");
        }

        Account account = this.getAccount(accountId);
        double balance = account.getBalance();
        if (balance < amount) {
            throw new Exception("The amount is not enough.");
        }
        account.setBalance(balance - amount);
    }

    @Override
    public void deposit(int accountId, double amount) throws Exception {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount.");
        }
        Account account = this.getAccount(accountId);
        account.setBalance(account.getBalance() + amount);
    }
}
