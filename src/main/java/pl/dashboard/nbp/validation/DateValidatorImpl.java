package pl.dashboard.nbp.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class DateValidatorImpl implements DateValidator {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public boolean isDateValid(final String dateToValidate){

        Optional.ofNullable(dateToValidate)
                .orElseThrow(IllegalArgumentException::new);

        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
        dateFormatter.setLenient(false);

        try {
            dateFormatter.parse(dateToValidate);
        } catch (ParseException e) {
            System.out.println("The provided data format is not correct");
            return false;
        }
        return true;
    }
}
