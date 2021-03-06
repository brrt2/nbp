package pl.dashboard.nbp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is a simple rest client allowing to get quotes for the specified currencies.
 *
 * @author Bartosz Pieczara
 */
public class RestClientImpl implements RestClient {

    private static final String[] DESIRED_CURRENCY_CODES = {"eur", "chf", "usd", "gbp"};
    private static final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/";

    private final DateValidator dateValidator;

    public RestClientImpl(DateValidator dateValidator) {

        this.dateValidator = dateValidator;
    }

    public void getCurrencyQuote(final String date) {

        if (!dateValidator.isDateValid(date)) {
            throw new IllegalArgumentException("The provided date " + date + " is not valid");
        }

        List<ResponseCurrencyQuote> listOfResponses = Collections.unmodifiableList(Arrays.asList(DESIRED_CURRENCY_CODES))
                .parallelStream()
                .map(code -> {
                    WebResource webResource = Client.create().resource(URL + code + "/" + date + "/");
                    ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
                    ResponseCurrencyQuote responseCurrencyQuote = null;

                    if (clientResponse.getStatus() != 200) {
                        throw new IllegalArgumentException("No quote available for the provided date " + date);
                    }

                    try {
                        responseCurrencyQuote = new ObjectMapper().readValue(clientResponse.getEntity(String.class), ResponseCurrencyQuote.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return responseCurrencyQuote;
                })
                .collect(Collectors.toList());

        new MessagePrinterImpl().printMessage(listOfResponses, date);
    }
}
