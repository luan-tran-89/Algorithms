package com.interview.kforce.questionNew3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public class BankingServiceImpl implements BankingService {
    private Map<Integer, Double> accounts;

    public BankingServiceImpl(double[] data) {
        accounts = new HashMap<>(data.length);
        for (int i = 0; i < data.length; i++) {
            accounts.put(i, data[i]); // Initialize all accounts with a balance of 0.0
        }
    }

    @Override
    public double getBalance(int accountId) {
        if (!accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        return accounts.get(accountId);
    }

    @Override
    public synchronized void withdraw(int accountId, double amount) {
        if (!accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        if (amount <= 0 || accounts.get(accountId) < amount) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        accounts.put(accountId, accounts.get(accountId) - amount);
    }


    @Override
    public synchronized void deposit(int accountId, double amount) {
        if (!accounts.containsKey(accountId)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        accounts.put(accountId, accounts.get(accountId) + amount);
    }
}
