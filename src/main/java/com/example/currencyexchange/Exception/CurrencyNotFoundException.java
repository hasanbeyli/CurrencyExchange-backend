package com.example.currencyexchange.Exception;

public class CurrencyNotFoundException extends RuntimeException {

    public CurrencyNotFoundException() {
    }

    public CurrencyNotFoundException(String message) {
        super(message);
    }
}
