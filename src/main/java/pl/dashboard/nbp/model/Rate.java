package pl.dashboard.nbp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the required fields from the collection object contained inside the response received
 * from the API of the Polish National Bank.
 *
 * @author Bartosz Pieczara
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    @JsonProperty("bid")
    private Double bid;
    @JsonProperty("ask")
    private Double ask;

    @JsonProperty("bid")
    public Double getBid() {
        return bid;
    }

    @JsonProperty("bid")
    public void setBid(Double bid) {
        this.bid = bid;
    }

    @JsonProperty("ask")
    public Double getAsk() {
        return ask;
    }

    @JsonProperty("ask")
    public void setAsk(Double ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return bid + ";  " + ask;
    }
}