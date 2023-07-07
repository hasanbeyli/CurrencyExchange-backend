package com.example.currencyexchange.repo;
import com.example.currencyexchange.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyDbRepository extends JpaRepository<Currency, Integer>{
}
