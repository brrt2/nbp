package pl.dashboard.nbp.repository;

import java.io.IOException;

public interface HttpProvider {

    void obtainCurrencyData(String date) throws IOException;
}
