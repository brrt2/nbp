package pl.dashboard.nbp;

import pl.dashboard.nbp.repository.HttpProviderImpl;
import pl.dashboard.nbp.validation.DateValidatorImpl;

import java.util.Optional;

public class MainClass {

    public static void main(String[] args)  {

      String providedDate = args[0];

        Optional.ofNullable(providedDate)
                .orElseThrow(IllegalArgumentException::new);

        new HttpProviderImpl(new DateValidatorImpl()).obtainCurrencyData("2018-04-04");
    }

}
