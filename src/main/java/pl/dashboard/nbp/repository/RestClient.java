package pl.dashboard.nbp.repository;

import java.io.IOException;

public interface RestClient {

    void obtainCurrencyData(String date) throws IOException;
}
