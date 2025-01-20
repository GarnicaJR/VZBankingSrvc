package com.vz.banking;

import com.vz.banking.util.SSLUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Demo {
    public static void main(String[] args) throws Exception {

        //load certificate in the program to avoid SSL issues
        SSLUtil.loadCertificate();

        //call to currency exchange service
        System.out.println(CurrencyExService.getPrice(Currency.DOLLAR));
        System.out.println(CurrencyExService.getPrice(Currency.RUBLO));
        System.out.println(CurrencyExService.getPrice(Currency.EURO));
    }
}