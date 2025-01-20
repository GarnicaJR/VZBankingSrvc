package com.vz.banking;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class CurrencyExService {

        private static final String VENEZUELA_BANK = "https://www.bcv.org.ve/";

        public static Double getPrice(Currency currency) {
            Document doc = null;
            try {
                doc = Jsoup.connect(VENEZUELA_BANK).get();
                Element currencyTag = doc.getElementById(currency.getCurrency());
                String result = currencyTag.select("strong").text().replace(",", ".");
                return Double.valueOf(result);
            } catch (Exception e) {
                System.err.println("Error getting the currency exchange " +  e);
            }
            return 0.0;
        }
}
