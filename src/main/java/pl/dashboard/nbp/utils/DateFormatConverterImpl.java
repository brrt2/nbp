package pl.dashboard.nbp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConverterImpl implements DateFormatConverter {

    public String transformDateFormat(String date) {

        final String OLD_FORMAT = "yyyy-MM-dd";
        final String NEW_FORMAT = "dd.MM.yyyy";

        SimpleDateFormat formatter = new SimpleDateFormat(OLD_FORMAT);
        Date dateToFormat = null;
        try {
            dateToFormat = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.applyPattern(NEW_FORMAT);
        return formatter.format(dateToFormat);
    }

}
