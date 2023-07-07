package com.example.currencyexchange.dto;

import com.example.currencyexchange.entity.Currency;

import java.util.ArrayList;
import java.util.List;

public record CurrencyResponseDto (Integer id, String name, String code){

    public static CurrencyResponseDto getCurrencyResponseDto(Currency currency) {
        return new CurrencyResponseDto(currency.getId(), currency.getName(), currency.getCode());
    }


    public static List<CurrencyResponseDto> getCurrencyResponseDtoList(List<Currency> currencyList) {
        List<CurrencyResponseDto> responseDtoList = new ArrayList<>();

        for (Currency currency: currencyList) {
            responseDtoList.add(getCurrencyResponseDto(currency));
        }

        return responseDtoList;

    }
}
