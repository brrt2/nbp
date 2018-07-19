package pl.dashboard.nbp.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.*;

public class DateFormatConverterImplTest {

    @DataProvider
    private Object[][] provideCorrectDates() {
        return new Object[][] {
                {"2018-04-04","04.04.2018"},
                {"2014-03-04","04.03.2014"},
                {"2015-12-05","05.12.2015"}
        };
    }

    @DataProvider
    private Object[][] provideIncorrectDates() {
        return new Object[][] {
                {"2018.04-04","04.04.2018"},
                {"2014-03:04","04.03.2014"},
                {"2015/12-05","05.12.2015"},
                {null,"05.12.2015"}
        };
    }


    @Test(dataProvider = "provideCorrectDates")
    public void shouldReturnTransformedStringWhenProvidedCorrectInput(String input, String output){

      assertThat(new DateFormatConverterImpl().transformDateFormat(input)).isEqualTo(output);

    }

    @Test(dataProvider = "provideIncorrectDates",expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionIfInputIsIncorrectOrNull(String input, String output){

        assertThat(new DateFormatConverterImpl().transformDateFormat(input)).isEqualTo(output);

    }

}