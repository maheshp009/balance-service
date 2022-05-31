package com.example.balanceservice.repository;

import com.example.balanceservice.model.Balance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BalanceRepository extends MongoRepository<Balance, String> {
//    List<Balance> findByid(String id);
//    List<Balance> findByaccountID(String accountId);
}
