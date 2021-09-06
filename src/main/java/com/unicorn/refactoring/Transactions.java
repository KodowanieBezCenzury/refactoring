package com.unicorn.refactoring;

import com.google.gson.Gson;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Transactions {

    private final List<BankingTransaction> onlineTransaction;

    public Transactions(List<BankingTransaction> onlineTransaction) {
        this.onlineTransaction = onlineTransaction;
    }

    Set<String> getDebitTransactions() {
        return onlineTransaction.stream()
                .filter(BankingTransaction::isDebit)
                .map(debitTransaction -> new Gson().toJson(debitTransaction))
                .collect(Collectors.toSet());
    }
}
