package com.example.balanceservice.controller;


import com.example.balanceservice.model.Balance;
import com.example.balanceservice.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BalanceController {

    @Autowired
    BalanceRepository  balanceRepository;

//    @GetMapping("/accounts")
//    public ResponseEntity<List<Balance>> getAllBalance(@RequestParam(required = false) String accountId) {
//
//   return  null;
//
//    }
//
//    @PostMapping("/accounts")
//    public ResponseEntity<Balance> createBalance(@RequestBody Balance balance) {
//        return null;
//
//    }

    @PostMapping("/tutorials")
    public ResponseEntity<Balance> createBalance(@RequestBody Balance balance) {
        try {
            Balance _balance = balanceRepository.save(new Balance(balance.getId(), balance.getAmount(), balance.getCurrency(),
                    balance.getAccountId(), balance.getCreatedAt(), balance.getUpdatedAt(), false));
            return new ResponseEntity<>(_balance, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}