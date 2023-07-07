package com.example.currencyexchange.repo;


import com.example.currencyexchange.dto.CurrencyResponseDto;
import com.example.currencyexchange.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CurrencyRepository {

    @Autowired
    CurrencyDbRepository currencyDbRepository;

    public Currency saveCurrency(Currency currency) {
        return currencyDbRepository.save(currency);
    }

    public Optional<Currency> getById(int id) {
        return currencyDbRepository.findById(id);
    }

    public List<Currency> getAllCurrency(){
        return currencyDbRepository.findAll();
    }

    public void deleteById(int id){
        currencyDbRepository.deleteById(id);
    }




}
