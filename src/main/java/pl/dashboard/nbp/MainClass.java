package pl.dashboard.nbp;

import pl.dashboard.nbp.repository.RestClientImpl;
import pl.dashboard.nbp.validation.DateValidatorImpl;

public class MainClass {

    public static void main(String[] args)  {
//
//      String providedDate = args[0];
//
//        Optional.ofNullable(providedDate)
//                .orElseThrow(IllegalArgumentException::new);

        new RestClientImpl(new DateValidatorImpl()).obtainCurrencyData("2018-04-04");
    }

}
