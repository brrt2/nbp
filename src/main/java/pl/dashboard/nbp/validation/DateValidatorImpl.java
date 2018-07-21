package pl.dashboard.nbp.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Optional;

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
            System.err.printf("%s is not a correct date format%n", dateToValidate);
            return false;
        }

        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The provided date refers to the future");
        }
        return true;
    }
}
