package pl.dashboard.nbp.validation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class DateValidatorImplTest {

    @DataProvider
   private Object[][] provideIncorrectDates() {
        return new Object[][] {
                {"04.04.2015"},
                {"03-05-2014"},
                {"01/02/2013"},
                {"03:10:2016"},
                {"2011.04.05"},
                {"2012/10/11"},
                {"2012:10:11"},
                {"2013-15-02"},
                {"2013-10:02"},
                {"2013-00:02"},
                {"2015-03-00"}
        };
    }

    @DataProvider
    private Object[][] provideCorrectDates() {
        return new Object[][] {
                {"2018-04-04"},
                {"2014-03-04"},
                {"2015-12-05"}
        };
    }


    @Test(dataProvider = "provideIncorrectDates")
    public void shouldReturnFalseWhenProvidedIncorrectDate(String date) {

      assertThat(new DateValidatorImpl().isDateValid(date)).isFalse();
    }

    @Test(dataProvider = "provideCorrectDates")
    public void shouldReturnTrueWhenProvidedCorrectDate(String date) {

        assertThat(new DateValidatorImpl().isDateValid(date)).isTrue();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNullPassedAsParameter() {

        new DateValidatorImpl().isDateValid(null);
    }


}