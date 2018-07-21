package pl.dashboard.nbp.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the response received from the API of the Polish National Bank.
 *
 * @author Bartosz Pieczara
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCurrencyQuote {

    @JsonProperty("code")
    private String code;
    @JsonProperty("rates")
    private List<Rate> rates;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("rates")
    public List<Rate> getRates() {
        return rates;
    }

    @JsonProperty("rates")
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public double getAskValue() {
       return rates.get(0).getAsk();
    }

    public double getBidValue() {
        return rates.get(0).getBid();
    }

    @Override
    public String toString() {

        return code + " " + "=" + rates;
    }
}