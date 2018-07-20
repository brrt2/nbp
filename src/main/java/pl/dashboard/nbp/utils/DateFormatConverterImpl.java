package pl.dashboard.nbp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class DateFormatConverterImpl implements DateFormatConverter {

    private static final String OLD_FORMAT = "yyyy-MM-dd";
    private static final String NEW_FORMAT = "dd.MM.yyyy";

    public String transformDateFormat(final String date) {

        Optional.ofNullable(date)
                .orElseThrow(()-> new IllegalArgumentException("No date has been provided"));

        SimpleDateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
        Date dateToFormat;
        try {
            dateToFormat = formatter.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("The provided data format is not correct");
        }
        formatter.applyPattern(NEW_FORMAT);
        return formatter.format(dateToFormat);
    }

}
