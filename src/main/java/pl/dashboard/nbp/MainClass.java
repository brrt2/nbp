package pl.dashboard.nbp;

/**
 * This is the launching class.
 *
 * @author Bartosz Pieczara
 */
public class MainClass {

    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No date has been provided");
        }

        new RestClientImpl(new DateValidatorImpl()).getCurrencyQuote(args[0]);
    }

}
