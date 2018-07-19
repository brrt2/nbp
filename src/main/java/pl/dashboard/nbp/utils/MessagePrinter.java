package pl.dashboard.nbp.utils;

import pl.dashboard.nbp.model.CurrencyResponse;

import java.text.ParseException;
import java.util.List;

public interface MessagePrinter {

    void printMessage(List<CurrencyResponse> currencyResponseList, final String date) throws ParseException;

}
