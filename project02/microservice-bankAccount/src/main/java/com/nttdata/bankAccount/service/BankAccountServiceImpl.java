package com.nttdata.bankAccount.service;

import com.nttdata.bankAccount.entity.BankAccount;
import com.nttdata.bankAccount.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BankAccountServiceImpl implements BankAccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public void createBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return (List<BankAccount>) bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccountById(Long id) {
        return bankAccountRepository.findById(id).orElseThrow();
    }

    @Override
    public void deposit(double amount, String accountNumber) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);

        bankAccount.setBalance(bankAccount.getBalance()+amount);

        bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount withdraw(double amount, String accountNumber) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
        double totalBalance = bankAccount.getBalance() - amount;

        if(Objects.equals(bankAccount.getAccountType(), "AHORROS") && totalBalance < 0){

            return bankAccount;

        }else if(Objects.equals(bankAccount.getAccountType(), "CORRIENTE") && totalBalance < -500){

            return bankAccount;

        }else{

            bankAccount.setBalance(totalBalance);
            bankAccountRepository.save(bankAccount);
            return bankAccount;
        }
    }

    @Override
    public void deleteBankAccountById(Long id) {
        bankAccountRepository.deleteById(id);
    }
}
