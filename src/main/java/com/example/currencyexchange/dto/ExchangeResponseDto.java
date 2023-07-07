package com.example.currencyexchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExchangeResponseDto {


    private String result;

    @JsonProperty("time_next_update_utc")
    private Date lastUpdateDate;

    @JsonProperty("base_code")
    private String baseCode;

    @JsonProperty("target_code")
    private String targetCode;

    @JsonProperty("conversion_rate")
    private Double rate;

    @JsonProperty("result_amount")
    private Double resultAmount;


}
