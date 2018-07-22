package pl.dashboard.nbp;

import java.util.List;

/**
 * This class prints the provided currency quotes list in the desired format.
 *
 * @author Bartosz Pieczara
 */
public class MessagePrinterImpl implements MessagePrinter {

    public void printMessage(List<ResponseCurrencyQuote> responseCurrencyQuoteList, final String date) {

        System.out.printf("%-3s %s\n", "Data:", new DateFormatConverterImpl().transformDateFormat(date));
        System.out.printf("%-10s %s %s\n", "Waluta = ", "kupno;", " sprzedaz");

        responseCurrencyQuoteList.forEach(responseCurrencyQuote -> System.out.printf("%-10s %s %s\n",
                responseCurrencyQuote.getCode(), responseCurrencyQuote.getAskValue() +
                        ";", responseCurrencyQuote.getBidValue()));
    }

}
