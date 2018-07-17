package pl.dashboard.nbp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import pl.dashboard.nbp.model.CurrencyResponse;
import pl.dashboard.nbp.utils.MessagePrinterImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpProviderImpl implements HttpProvider {


    public void obtainCurrencyData(String date) throws IOException {

        List<String> listOfCurrencyCodes = new ArrayList<>(Arrays.asList("eur","chf","usd","gbp"));
        List<CurrencyResponse> listOfResponses = new ArrayList<>();

        Client client = Client.create();
        ObjectMapper objectMapper = new ObjectMapper();

        for (String code : listOfCurrencyCodes) {

            WebResource webResource = client.resource("http://api.nbp.pl/api/exchangerates/rates/c/"+ code + "/"+ date+ "/");
            ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
            String obtainedJson = clientResponse.getEntity(String.class);
            CurrencyResponse currencyResponse = objectMapper.readValue(obtainedJson,CurrencyResponse.class);
            if(clientResponse.getStatus() != 200) {
                throw new RuntimeException("HTTP error " + clientResponse.getStatus());
            }
            listOfResponses.add(currencyResponse);
        }

        launchPrinter(listOfResponses);

    }

    private void launchPrinter(List<CurrencyResponse> responseList) {

        new MessagePrinterImpl().printMessage(responseList);

    }
}
