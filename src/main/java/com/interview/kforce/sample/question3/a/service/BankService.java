package com.interview.kforce.sample.question3.a.service;

/**
 * @author gasieugru
 */
public interface BankService {

    double getBalance(int accountId) throws Exception;

    void withdraw(int accountId, double amount) throws Exception;

    void deposit(int accountId, double amount) throws Exception;

}
