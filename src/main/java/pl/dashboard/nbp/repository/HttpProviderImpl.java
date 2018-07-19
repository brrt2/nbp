package pl.dashboard.nbp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import pl.dashboard.nbp.model.CurrencyResponse;
import pl.dashboard.nbp.utils.MessagePrinterImpl;
import pl.dashboard.nbp.validation.DateValidator;
import pl.dashboard.nbp.validation.DateValidatorImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HttpProviderImpl implements HttpProvider {

    private static final String[] DESIRED_CURRENCY_CODES = {"eur","chf","usd","gbp"};
    private final DateValidator dateValidator;


    public HttpProviderImpl(DateValidator dateValidator) {
        this.dateValidator = dateValidator;
    }

    public void obtainCurrencyData(final String date)  {

        if(!dateValidator.isDateValid(date)){
            throw new IllegalArgumentException("Podana data nie jest prawidłowa");
        }

        List<CurrencyResponse> listOfResponses = Collections.unmodifiableList(Arrays.asList(DESIRED_CURRENCY_CODES))
                .parallelStream()
                .map(code->{
                    WebResource webResource = Client.create().resource("http://api.nbp.pl/api/exchangerates/rates/c/"+ code + "/"+ date+ "/");
                    ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
                    CurrencyResponse currencyResponse = null;
                    try {
                        currencyResponse = new ObjectMapper().readValue(clientResponse.getEntity(String.class),CurrencyResponse.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return currencyResponse;
                })
                .collect(Collectors.toList());

        new MessagePrinterImpl().printMessage(listOfResponses, date);
    }
}
