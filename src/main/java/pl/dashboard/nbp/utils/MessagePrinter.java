package pl.dashboard.nbp.utils;

import pl.dashboard.nbp.model.ResponseCurrencyQuote;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;


/**
 * Supplies a method for printing currency quotes from a list provided as argument alongside the quote date.
 *
 * @author Bartosz Pieczara
 */
public interface MessagePrinter {

    void printMessage(List<ResponseCurrencyQuote> responseCurrencyQuoteList, final String date) throws ParseException, UnsupportedEncodingException;

}
