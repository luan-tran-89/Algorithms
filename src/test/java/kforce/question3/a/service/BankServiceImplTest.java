package kforce.question3.a.service;

import com.interview.kforce.sample.question3.a.model.Account;
import com.interview.kforce.sample.question3.a.service.BankServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author gasieugru
 */
public class BankServiceImplTest {
    List<Account> accountList = new ArrayList<>();
    private BankServiceImpl bankService;

    @Before
    public void setUp() throws Exception {
        accountList.add(new Account(1, 5000));
        accountList.add(new Account(2, 0));
        bankService = new BankServiceImpl(accountList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBalance_invalidAccountId() throws Exception {
        bankService.getBalance(-1);
    }

    @Test(expected = Exception.class)
    public void testGetBalance_accountNotFound() throws Exception {
        bankService.getBalance(5);
    }

    @Test
    public void testGetBalance() throws Exception {
        double balance = bankService.getBalance(1);
        assertEquals((double) 5000, balance, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdraw_invalidAccountId() throws Exception {
        bankService.withdraw(-1, 1000);
    }

    @Test(expected = Exception.class)
    public void testWithdraw_accountNotFound() throws Exception {
        bankService.withdraw(5, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdraw_invalidAmount() throws Exception {
        bankService.withdraw(1, -1000);
    }

    @Test(expected = Exception.class)
    public void testWithdraw_NotEnoughBalance() throws Exception {
        bankService.withdraw(1, 10000);
    }

    @Test
    public void testWithdraw() throws Exception {
        double currentBalance = accountList.get(0).getBalance();
        double withdrawAmount = 1000;
        bankService.withdraw(1, withdrawAmount);
        Account account = accountList.get(0);

        assertEquals(currentBalance - withdrawAmount, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeposit_invalidAccountId() throws Exception {
        bankService.deposit(-1, 1000);
    }

    @Test(expected = Exception.class)
    public void testDeposit_accountNotFound() throws Exception {
        bankService.deposit(5, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeposit_invalidAmount() throws Exception {
        bankService.deposit(1, -1000);
    }

    @Test
    public void testDeposit() throws Exception {
        double currentBalance = accountList.get(0).getBalance();
        double depositAmount = 1000;
        bankService.deposit(1, depositAmount);
        Account account = accountList.get(0);

        assertEquals(currentBalance + depositAmount, account.getBalance(), 0.001);
    }
}
