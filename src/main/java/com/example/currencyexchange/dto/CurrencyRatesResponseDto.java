package com.example.currencyexchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class CurrencyRatesResponseDto {

    private String result;

    @JsonProperty("base_code")
    private String base;

    @JsonProperty("time_last_update_utc")
    private Date lastUpdateDate;

    @JsonProperty("conversion_rates")
    private Map<String, Double> rates;

}
