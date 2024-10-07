package com.nttdata.transaction.bankaccount;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msvc-bankAccount", url = "localhost:9090/api/bankAccount")
public interface BankAccountTransaction {

    @PutMapping("/cuentas/{accountNumber}/depositar")
    void deposit(@RequestBody double amount, @PathVariable String accountNumber);

    @PutMapping("/cuentas/{accountNumber}/retirar")
    void withdraw(@RequestBody double amount, @PathVariable String accountNumber);

}
