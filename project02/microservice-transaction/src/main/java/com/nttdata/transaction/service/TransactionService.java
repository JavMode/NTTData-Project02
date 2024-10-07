package com.nttdata.transaction.service;

import com.nttdata.transaction.entity.Transaction;

import java.util.List;

public interface TransactionService {

    void deposit(Transaction transaction);

    void withdraw(Transaction transaction);

    void transfer(Transaction transaction);

    List<Transaction> getHistory();

}
