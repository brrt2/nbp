package pl.dashboard.nbp.utils;

import pl.dashboard.nbp.model.ResponseCurrencyQuote;

import java.text.ParseException;
import java.util.List;

public interface MessagePrinter {

    void printMessage(List<ResponseCurrencyQuote> responseCurrencyQuoteList, final String date) throws ParseException;

}
