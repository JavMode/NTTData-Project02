package com.nttdata.transaction.service;

import com.nttdata.transaction.entity.Transaction;
import com.nttdata.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void deposit(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void withdraw(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void transfer(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getHistory() {
        return transactionRepository.findAll();
    }
}
