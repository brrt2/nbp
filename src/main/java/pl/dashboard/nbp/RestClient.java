package pl.dashboard.nbp;

import java.io.IOException;

/**
 * Provides a method for getting currency quotes based on a String argument.
 *
 * @author Bartosz Pieczara
 */
public interface RestClient {


    void getCurrencyQuote(String date) throws IOException;
}
