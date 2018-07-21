package pl.dashboard.nbp.repository;

import org.testng.annotations.Test;
import pl.dashboard.nbp.validation.DateValidator;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestClientImplTest {

    private static final String SAMPLE_DATE = "2018-04-04";

    @Test
    public void shouldCallTheIsValidDateMethodWhenThisMethodCalled() {

        // Arrange
        DateValidator dateValidator = mock(DateValidator.class);
        when(dateValidator.isDateValid(SAMPLE_DATE)).thenReturn(true);

        // Act
        new RestClientImpl(dateValidator).getCurrencyQuote(SAMPLE_DATE);

        // Assert
        verify(dateValidator).isDateValid(SAMPLE_DATE);

    }

}