package pl.dashboard.nbp.validation;

import pl.dashboard.nbp.repository.HttpProvider;
import pl.dashboard.nbp.repository.HttpProviderImpl;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidatorImpl implements DateValidator {

    public void validateDate(String date) {

        if(isThisDateValid(date,"yyyy-MM-dd")){
            launchHttpProvider(date);
        }

    }

    private boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {
            sdf.parse(dateToValidate);

        } catch (ParseException e) {

            System.out.println("Podana data nie jest prawidłowa,wlasciwy format - dd-mm-rrrr");
            return false;
        }

        return true;
    }


    private void launchHttpProvider(String date) {

        HttpProvider httpProvider = new HttpProviderImpl();
        try {
            httpProvider.obtainCurrencyData(date);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
