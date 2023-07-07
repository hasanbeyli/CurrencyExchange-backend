package com.example.currencyexchange.service;

import com.example.currencyexchange.Exception.CurrencyNotFoundException;
import com.example.currencyexchange.dto.CurrencyRequestDto;
import com.example.currencyexchange.dto.CurrencyResponseDto;
import com.example.currencyexchange.entity.Currency;
import com.example.currencyexchange.repo.CurrencyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Transactional
    public CurrencyResponseDto create(CurrencyRequestDto currencyRequestDto) {
        Currency currency = Currency.getCurrency(currencyRequestDto);

        Currency savedCurrency = currencyRepository.saveCurrency(currency);

        return CurrencyResponseDto.getCurrencyResponseDto(savedCurrency);
    }

    public List<CurrencyResponseDto> getAll() {
        List<Currency> currencyList = currencyRepository.getAllCurrency();

        return CurrencyResponseDto.getCurrencyResponseDtoList(currencyList);
    }

    public CurrencyResponseDto getById(int id) {
        Currency currency = currencyRepository.getById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency not found " + id));
        return CurrencyResponseDto.getCurrencyResponseDto(currency);
    }

    @Transactional
    public CurrencyResponseDto update(Integer id, CurrencyRequestDto currencyRequestDto) {
        Currency currency = currencyRepository.getById(id)
                .orElseThrow(() -> new CurrencyNotFoundException("Currency not found " + id));

        Currency updatedCurrency = Currency.getCurrency(currencyRequestDto);
        updatedCurrency.setId(currency.getId());

        Currency savedCurrency = currencyRepository.saveCurrency(updatedCurrency);

        return CurrencyResponseDto.getCurrencyResponseDto(savedCurrency);
    }


    public void deleteById(int id){
        currencyRepository.deleteById(id);
    }
}
