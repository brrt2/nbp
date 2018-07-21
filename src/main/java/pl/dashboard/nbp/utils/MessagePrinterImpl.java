package pl.dashboard.nbp.utils;

import pl.dashboard.nbp.model.ResponseCurrencyQuote;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class MessagePrinterImpl implements MessagePrinter {

    public void printMessage(List<ResponseCurrencyQuote> responseCurrencyQuoteList, final String date) {

        System.out.printf("%-3s %s\n", "Data:", new DateFormatConverterImpl().transformDateFormat(date));
        System.out.printf("%-10s %s %s\n", "Waluta = ", "kupno;", " sprzedaz");

        responseCurrencyQuoteList.forEach(responseCurrencyQuote -> System.out.printf("%-10s %s %s\n",
                responseCurrencyQuote.getCode(), responseCurrencyQuote.getAskValue() +
                        ";", responseCurrencyQuote.getBidValue()));
    }

}
