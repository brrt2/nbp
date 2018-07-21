package pl.dashboard.nbp.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateFormatConverterImpl implements DateFormatConverter {

    private static final String NEW_FORMAT = "dd.MM.yyyy";

    public String transformDateFormat(final String date) {

        Optional.ofNullable(date)
                .orElseThrow(() -> new IllegalArgumentException("No date has been provided"));

        LocalDate providedDateString = LocalDate.parse(date);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(NEW_FORMAT);
        return providedDateString.format(dateFormatter);
    }

}
