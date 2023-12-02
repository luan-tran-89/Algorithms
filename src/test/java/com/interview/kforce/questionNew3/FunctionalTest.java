package com.interview.kforce.questionNew3;

import org.junit.jupiter.api.*;

import java.time.Duration;

/**
 * @author gasieugru
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class FunctionalTest {

    private BankingService bankingService;

    @BeforeEach
    public void setup() {
        double[] accounts = {1000, 1000, 1000};
        bankingService = new BankingServiceImpl(accounts);
    }

    @Nested
    @DisplayName("Functional tests of the withdrawal method")
    class WithdrawTests {


        @Test
        @DisplayName ("Should withdraw when amount is valid and account exists")
        public void shouldWithdrawSuccessfullywhenAmountIsValidAndAccountExists() {
            Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                // when
                bankingService.withdraw(0, 100);
                bankingService.withdraw(1, 200);
                bankingService.withdraw(2, 300);
                //then
                Assertions.assertEquals(bankingService.getBalance(0), 900);
                Assertions.assertEquals(bankingService.getBalance(1), 800);
                Assertions.assertEquals(bankingService.getBalance(2), 700);
            });
        }
    }
}
