package com.vz.banking;

public enum Currency{
    DOLLAR("dolar"),
    EURO("euro"),
    RUBLO("rublo");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
