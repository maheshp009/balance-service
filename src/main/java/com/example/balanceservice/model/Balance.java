package com.example.balanceservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "balance")
public class Balance {

    @Id
    private String id;
    private  String amount;
    private String currency;
    private  String accountId;
    private String createdAt;
    private  String updatedAt;

    public Balance(){

    }



    public Balance(String id , String amount , String currency , String accountId , String createdAt , String updatedAt , boolean b) {

        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.accountId = accountId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", amount=" + amount + ", currency=" + currency + ", accountId=" + accountId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt +" ]";
    }
}
