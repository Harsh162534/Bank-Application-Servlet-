package com.aurionpro.entity;

import java.sql.Date;

public class Transaction {

    private String senderAccountNumber;
    private String receiverAccountNumber;
    private String transactionType;
    private int amount;
    private Date date;  
    
    // Constructor to initialize all fields
    public Transaction(String senderAccountNumber, String receiverAccountNumber, String transactionType, int amount, Date date) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;  // Initialize the date field
    }

    // Getters and setters for all fields
    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
