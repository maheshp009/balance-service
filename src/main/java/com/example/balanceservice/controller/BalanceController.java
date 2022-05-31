package com.example.balanceservice.controller;


import com.example.balanceservice.model.Balance;
import com.example.balanceservice.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/balance")
    public ResponseEntity<Balance> createBalance(@RequestBody Balance balance) {
        try {
            Balance _balance = balanceRepository.save(new Balance(balance.getId(), balance.getAmount(), balance.getCurrency(),
                    balance.getAccountId(), balance.getCreatedAt(), balance.getUpdatedAt(), false));
            return new ResponseEntity<>(_balance, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/accounts")
//    public ResponseEntity<List<Balance>> getAllBalance(@RequestParam(required = false) String id) {
//        try {
//            List<Balance> accountID = new ArrayList<Balance>();
//            if (accountID == null)
//                balanceRepository.findAll().forEach(accountID::add);
//            else
//                balanceRepository.findByaccountID(String.valueOf(accountID)).forEach(accountID::add);
//            if (accountID.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(accountID, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
@GetMapping("/balance/{id}")
public ResponseEntity<Balance> getBalanceById(@PathVariable("id") String id) {
    Optional<Balance> balance = balanceRepository.findById(id);
    if (balance.isPresent()) {
        return new ResponseEntity<>(balance.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

    @GetMapping("/balance/accountsId/{accountId}")
    public ResponseEntity<Balance> getBalanceByAccountId(@PathVariable("accountId") String accountId) {
        Balance balance = balanceRepository.findByAccountId(accountId);
        return  new ResponseEntity<>(balance,HttpStatus.OK);
//        if (balance.isPresent()) {
//            return new ResponseEntity<>(balance.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

    }


}