package com.unicorn.refactoring;

public class BookingTransactionsApplicationService {

    private final TransferTransactionAdapter transferTransactionAdapter;

    public BookingTransactionsApplicationService(TransferTransactionAdapter transferTransactionAdapter) {
        this.transferTransactionAdapter = transferTransactionAdapter;
    }

    public void bookTransaction(BankingTransaction paymentTransaction, boolean isPrioritized) {
        if (isPrioritized) {
            validateTransaction(paymentTransaction);
            checkForHolidays(paymentTransaction);
            sendImmediately(paymentTransaction);
        } else {
            send(paymentTransaction);
        }
    }

    private void sendImmediately(BankingTransaction paymentTransaction) {
        transferTransactionAdapter.sendImmediate(paymentTransaction);
    }

    private void send(BankingTransaction paymentTransaction) {
        transferTransactionAdapter.send(paymentTransaction);
    }

    private void validateTransaction(BankingTransaction paymentTransaction) {

    }

    private void checkForHolidays(BankingTransaction paymentTransaction) {

    }

}
