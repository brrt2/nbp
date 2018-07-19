package pl.dashboard.nbp.utils;

import pl.dashboard.nbp.model.CurrencyResponse;
import java.util.List;

public class MessagePrinterImpl implements MessagePrinter {

    public void printMessage(List<CurrencyResponse> currencyResponseList, final String date)  {

        System.out.printf("%-3s %s\n","Data:",new DateFormatConverterImpl().transformDateFormat(date));
        System.out.printf("%-10s %s %s\n","Waluta = ", "kupno;"," sprzedaż");

        currencyResponseList.forEach(currencyResponse-> System.out.printf("%-10s %s %s\n", currencyResponse.getCode(), currencyResponse.getRates().get(0).getAsk()+";", currencyResponse.getRates().get(0).getBid()));

    }


}
