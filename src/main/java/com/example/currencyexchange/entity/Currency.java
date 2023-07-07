package com.example.currencyexchange.entity;


import com.example.currencyexchange.dto.CurrencyRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class  Currency {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "currency_code")
    private String code;

    @Column(name = "currency_name")
    private String name;

    public static Currency getCurrency (CurrencyRequestDto currencyRequestDto) {

        Currency currency = new Currency();
        currency.name = currencyRequestDto.name();
        currency.code = currencyRequestDto.code();

        return currency;
    }
}
