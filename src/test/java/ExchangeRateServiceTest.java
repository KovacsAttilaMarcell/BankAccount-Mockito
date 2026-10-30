import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExchangeRateServiceTest {

    @Test
    void mockedExchangeRateReturnsConfiguredValue() {

        ExchangeRateService exchangeRateService = mock(ExchangeRateService.class);

        when(exchangeRateService.getExchangeRate("EUR", "HUF"))
                .thenReturn(400.0);

        double exchangeRate = exchangeRateService.getExchangeRate("EUR", "HUF");

        assertEquals(400.0, exchangeRate, 0.001);

        verify(exchangeRateService, times(1))
                .getExchangeRate("EUR", "HUF");
    }
}
