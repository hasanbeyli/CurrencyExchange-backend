package com.example.currencyexchange.controller;

import com.example.currencyexchange.dto.CurrencyRatesResponseDto;
import com.example.currencyexchange.dto.ExchangeResponseDto;
import com.example.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/rates")
    public ResponseEntity<CurrencyRatesResponseDto> getCurrencyRates(@RequestParam String base) {
        return ResponseEntity.ok(exchangeService.getCurrencyRates(base));
    }

    @GetMapping
    public ResponseEntity<ExchangeResponseDto> currencyExchange(@RequestParam String base,
                                                                @RequestParam String target,
                                                                @RequestParam double amount) {
        return ResponseEntity.ok(exchangeService.currencyExchange(base, target, amount));
    }

}
