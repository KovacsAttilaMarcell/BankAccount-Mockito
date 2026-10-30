import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void newAccountHasZeroBalance() {
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void depositIncreasesBalance() {
        account.deposit(1000);
        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    void multipleDepositsAreAdded() {
        account.deposit(1000);
        account.deposit(500);
        account.deposit(250);

        assertEquals(1750.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawDecreasesBalance() {
        account.deposit(1000);
        account.withdraw(400);

        assertEquals(600.0, account.getBalance(), 0.001);
    }

    @Test
    void entireBalanceCanBeWithdrawn() {
        account.deposit(1000);
        account.withdraw(1000);

        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void withdrawingTooMuchThrowsException() {
        account.deposit(500);
        double originalBalance = account.getBalance();

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(600));

        assertEquals(originalBalance, account.getBalance(), 0.001);
    }

    @Test
    void negativeDepositThrowsException() {
        account.deposit(500);
        double originalBalance = account.getBalance();

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));

        assertEquals(originalBalance, account.getBalance(), 0.001);
    }

    @Test
    void zeroDepositThrowsException() {
        account.deposit(500);
        double originalBalance = account.getBalance();

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));

        assertEquals(originalBalance, account.getBalance(), 0.001);
    }

    @Test
    void negativeWithdrawalThrowsException() {
        account.deposit(500);
        double originalBalance = account.getBalance();

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-100));

        assertEquals(originalBalance, account.getBalance(), 0.001);
    }

    @Test
    void zeroWithdrawalThrowsException() {
        account.deposit(500);
        double originalBalance = account.getBalance();

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0));

        assertEquals(originalBalance, account.getBalance(), 0.001);
    }
}
