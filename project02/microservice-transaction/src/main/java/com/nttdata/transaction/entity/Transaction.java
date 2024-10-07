package com.nttdata.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "Transactions")
public class Transaction {

    @Id
    private String id;
    private String transactionType;
    private Double amount;
    private LocalDateTime datetime;
    private String account;

    public Transaction(){
        this.datetime = LocalDateTime.now();
    }

}
