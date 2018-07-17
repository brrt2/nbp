package pl.dashboard.nbp.utils;

import pl.dashboard.nbp.model.CurrencyResponse;

import java.util.List;

public class MessagePrinterImpl implements MessagePrinter {

    public void printMessage(List<CurrencyResponse> currencyResponseList) {


        currencyResponseList.forEach(System.out::println);

    }
}
