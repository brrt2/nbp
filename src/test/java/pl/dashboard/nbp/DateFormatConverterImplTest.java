package pl.dashboard.nbp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.dashboard.nbp.DateFormatConverter;
import pl.dashboard.nbp.DateFormatConverterImpl;

import java.time.format.DateTimeParseException;

import static org.assertj.core.api.Assertions.*;

public class DateFormatConverterImplTest {

    @DataProvider
    private Object[][] provideCorrectDates() {
        return new Object[][]{
                {"2018-04-04", "04.04.2018"},
                {"2014-03-04", "04.03.2014"},
                {"2015-12-05", "05.12.2015"}
        };
    }

    @DataProvider
    private Object[][] provideIncorrectDates() {
        return new Object[][]{
                {"2018.04-04", "04.04.2018"},
                {"2014-03:04", "04.03.2014"},
                {"2015/12-05", "05.12.2015"}
        };
    }

    private DateFormatConverter dateFormatConverter;

    @BeforeMethod
    public void setUp() {
        dateFormatConverter = new DateFormatConverterImpl();
    }


    @Test(dataProvider = "provideCorrectDates")
    public void shouldReturnTransformedStringWhenProvidedCorrectInput(String input, String output) {

        assertThat(dateFormatConverter.transformDateFormat(input)).isEqualTo(output);

    }

    @Test(dataProvider = "provideIncorrectDates", expectedExceptions = DateTimeParseException.class)
    public void shouldThrowExceptionIfInputIsIncorrect(String input, String output) {

        assertThat(dateFormatConverter.transformDateFormat(input)).isEqualTo(output);

    }

    @Test(dataProvider = "provideIncorrectDates", expectedExceptions = DateTimeParseException.class)
    public void shouldThrowExceptionIfInputIsNull(String input, String output) {

        assertThat(dateFormatConverter.transformDateFormat(input)).isEqualTo(output);

    }

    @Test(expectedExceptions = IllegalArgumentException.class
            , expectedExceptionsMessageRegExp = "No date has been provided")
    public void shouldThrowExceptionIllegalArgumentExceptionWhenNullValuePassedAsArgument() {

        dateFormatConverter.transformDateFormat(null);

    }

}