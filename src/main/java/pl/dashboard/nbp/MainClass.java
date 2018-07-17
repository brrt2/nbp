package pl.dashboard.nbp;

import pl.dashboard.nbp.validation.DateValidator;
import pl.dashboard.nbp.validation.DateValidatorImpl;


public class MainClass {

    public static void main(String[] args)  {

//      String providedDate = args[0];

        DateValidator dateValidator = new DateValidatorImpl();
        dateValidator.validateDate("2018-04-04");
    }

}
