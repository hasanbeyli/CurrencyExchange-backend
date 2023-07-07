package com.example.currencyexchange.controller;

import com.example.currencyexchange.dto.CurrencyRequestDto;
import com.example.currencyexchange.dto.CurrencyResponseDto;
import com.example.currencyexchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping
    public ResponseEntity<CurrencyResponseDto> create(@RequestBody CurrencyRequestDto currencyRequestDto) {
        CurrencyResponseDto currencyResponseDto = currencyService.create(currencyRequestDto);

        return ResponseEntity.created(URI.create("/api/currencies/" + currencyResponseDto.id()))
                .body(currencyResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResponseDto>> getAll() {
        return ResponseEntity.ok(currencyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyResponseDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(currencyService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyResponseDto> update(@PathVariable int id, @RequestBody CurrencyRequestDto currencyRequestDto) {

        return ResponseEntity.ok(currencyService.update(id, currencyRequestDto));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        currencyService.deleteById(id);
    }
}
