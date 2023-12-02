package com.interview.kforce.questionNew3;

/**
 * @author gasieugru
 */
public interface BankingService {

    double getBalance(int accountId);

    void withdraw(int accountId, double amount);

    void deposit(int accountId, double amount);

}
