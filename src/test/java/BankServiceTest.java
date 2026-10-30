import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankServiceTest {

    private BankAccount account;
    private NotificationService notificationService;
    private BankService bankService;

    @BeforeEach
    void setUp() {
        account = new BankAccount();

        notificationService = mock(NotificationService.class);

        bankService = new BankService(account, notificationService);
    }

    @Test
    void successfulDepositIncreasesBalance() {
        bankService.deposit(1000);

        assertEquals(1000.0, account.getBalance(), 0.001);
    }

    @Test
    void successfulDepositSendsNotification() {
        bankService.deposit(500);

        verify(notificationService).send("Sikeres befizetés: 500.0");
    }

    @Test
    void notificationIsSentExactlyOnce() {
        bankService.deposit(250);

        verify(notificationService, times(1))
                .send("Sikeres befizetés: 250.0");

        verifyNoMoreInteractions(notificationService);
    }

    @Test
    void failedDepositDoesNotSendNotification() {
        assertThrows(IllegalArgumentException.class,
                () -> bankService.deposit(-100));

        verify(notificationService, never()).send(anyString());

        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    void zeroDepositDoesNotSendNotification() {
        assertThrows(IllegalArgumentException.class,
                () -> bankService.deposit(0));

        verifyNoInteractions(notificationService);

        assertEquals(0.0, account.getBalance(), 0.001);
    }
}
