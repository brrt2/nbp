package pl.dashboard.nbp.validation;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
                {"2015-03-00"},
                {"2005-3-00"},
                {"2005-03-2"},
                {"abcd-ef-gh"},
                {"a--rh"},
                {""},
                {" "},
                {" !@#$,"},
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

    @DataProvider
    private Object[][] provideFutureDates() {
        return new Object[][] {
                {"2028-09-04"},
                {"2024-05-04"},
                {"2019-10-05"},
                {"2018-11-05"},
        };
    }

    private DateValidator dateValidator;

    @BeforeMethod
    public void setUp(){
        dateValidator = new DateValidatorImpl();
    }


    @Test(dataProvider = "provideIncorrectDates")
    public void shouldReturnFalseWhenProvidedIncorrectDate(String date) {

      assertThat(dateValidator.isDateValid(date)).isFalse();
    }

    @Test(dataProvider = "provideCorrectDates")
    public void shouldReturnTrueWhenProvidedCorrectDate(String date) {

        assertThat(dateValidator.isDateValid(date)).isTrue();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "No date has been provided")
    public void shouldThrowIllegalArgumentExceptionWhenNullPassedAsParameter() {

        dateValidator.isDateValid(null);
    }

    @Test(dataProvider = "provideFutureDates",expectedExceptions = IllegalArgumentException.class)
    public void shouldReturnFalseWhenFutureDatePassedAsArgument(String date) {

        dateValidator.isDateValid(date);
    }


}