package com.example.currencyexchange.service;

import com.example.currencyexchange.dto.CurrencyRatesResponseDto;
import com.example.currencyexchange.dto.ExchangeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;

@Service
public class ExchangeService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "68cd17e18c9a95620b144c0d";

    public CurrencyRatesResponseDto getCurrencyRates(String base) {

        String requestUrl = BASE_URL + "%s/latest/%s".formatted(API_KEY, base);

        return restTemplate.getForObject(requestUrl, CurrencyRatesResponseDto.class);
    }

    public ExchangeResponseDto currencyExchange(String base, String target, double amount) {

        String requestUrl = BASE_URL + "%S/pair/%s/%s".formatted(API_KEY, base, target);

        ExchangeResponseDto exchangeResponseDto = restTemplate.getForObject(requestUrl, ExchangeResponseDto.class);

        DecimalFormat df = new DecimalFormat("0.00");
        String resultAmount = df.format(amount * exchangeResponseDto.getRate());

        exchangeResponseDto.setResultAmount(Double.valueOf(resultAmount));

        return exchangeResponseDto;
    }


}
