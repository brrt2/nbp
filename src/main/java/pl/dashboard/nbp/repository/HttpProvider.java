package pl.dashboard.nbp.repository;

import pl.dashboard.nbp.model.CurrencyResponse;

import java.io.IOException;

public interface HttpProvider {

    void obtainCurrencyData(String date) throws IOException;
}
