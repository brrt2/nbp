package pl.dashboard.nbp;

import pl.dashboard.nbp.repository.RestClientImpl;
import pl.dashboard.nbp.validation.DateValidatorImpl;

public class MainClass {

    public static void main(String[] args) {

        new RestClientImpl(new DateValidatorImpl()).getCurrencyQuote(args[0]);
    }

}
