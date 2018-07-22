package pl.dashboard.nbp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Optional;

/**
 * This class allows to check if the date provided by user is in the proper format.
 *
 * @author Bartosz Pieczara
 */
public class DateValidatorImpl implements DateValidator {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public boolean isDateValid(final String dateToValidate) {

        Optional.ofNullable(dateToValidate)
                .orElseThrow(() -> new IllegalArgumentException("No date has been provided"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate date;

        try {
            date = LocalDate.parse(dateToValidate, formatter);
        } catch (DateTimeParseException exc) {
            System.out.printf("%s is not a correct date format%n", dateToValidate);
            return false;
        }

        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The provided date " + dateToValidate + " refers to the future");
        }
        return true;
    }
}
