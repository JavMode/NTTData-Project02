package com.nttdata.transaction.controller;

import com.nttdata.transaction.bankaccount.BankAccountTransaction;
import com.nttdata.transaction.entity.Transaction;
import com.nttdata.transaction.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private BankAccountTransaction bankAccountTransaction;

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/transacciones/deposito")
    @ResponseStatus(HttpStatus.CREATED)
    public void deposit(@RequestBody Transaction transaction){
        bankAccountTransaction.deposit(transaction.getAmount(), transaction.getAccount());
        transactionService.deposit(transaction);
    }

    @PostMapping("/transacciones/retiro")
    @ResponseStatus(HttpStatus.CREATED)
    public void withdraw(@RequestBody Transaction transaction){
        bankAccountTransaction.withdraw(transaction.getAmount(), transaction.getAccount());
        transactionService.withdraw(transaction);
    }

    @PostMapping("/transacciones/transferencia")
    @ResponseStatus(HttpStatus.CREATED)
    public void transfer(@RequestBody Transaction transaction){
        bankAccountTransaction.deposit(transaction.getAmount(), transaction.getAccount());
        transactionService.transfer(transaction);
    }

    @GetMapping("/transacciones/historial")
    public ResponseEntity<?> getHistory(){
        return ResponseEntity.ok(transactionService.getHistory());
    }

}
