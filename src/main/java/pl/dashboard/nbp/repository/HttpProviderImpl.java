package pl.dashboard.nbp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import pl.dashboard.nbp.model.CurrencyResponse;
import pl.dashboard.nbp.utils.MessagePrinterImpl;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HttpProviderImpl implements HttpProvider {

    private static final String[] desiredCurrencyCodes = {"eur","chf","usd","gbp"};

    public void obtainCurrencyData(final String date)  {

        List<CurrencyResponse> listOfResponses = Collections.unmodifiableList(Arrays.asList(desiredCurrencyCodes))
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
                   checkIfHttpStatusOk(clientResponse.getStatus());
                    return currencyResponse;
                })
                .collect(Collectors.toList());

        launchPrinter(listOfResponses, date);
    }

    private void launchPrinter(List<CurrencyResponse> responseList, final String date) {
        new MessagePrinterImpl().printMessage(responseList, date);
    }

    private boolean checkIfHttpStatusOk(int status) {
        if(status != 200) {
            throw new RuntimeException("HTTP error with status " + status);
        } else return true;
    }


}
