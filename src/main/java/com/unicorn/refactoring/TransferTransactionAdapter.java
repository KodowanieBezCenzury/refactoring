package com.unicorn.refactoring;

public interface TransferTransactionAdapter {
    void send(BankingTransaction paymentTransaction);

    void sendImmediate(BankingTransaction paymentTransaction);
}
