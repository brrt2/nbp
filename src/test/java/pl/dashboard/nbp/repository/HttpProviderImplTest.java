package pl.dashboard.nbp.repository;

import org.testng.annotations.Test;
import pl.dashboard.nbp.validation.DateValidator;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class HttpProviderImplTest {

    @Test
    public void shouldCallTheIsValidDateMethodWhenThisMethodCalled() {

        String date = "2018-04-04";
        DateValidator dateValidator = mock(DateValidator.class);
        when(dateValidator.isDateValid(date)).thenReturn(true);
        new HttpProviderImpl(dateValidator).obtainCurrencyData(date);
        verify(dateValidator).isDateValid(date);

    }

}