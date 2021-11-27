package com.unicorn.refactoring;

public class BookingTransactionsApplicationService {

    private final TransferTransactionAdapter transferTransactionAdapter;

    public BookingTransactionsApplicationService(TransferTransactionAdapter transferTransactionAdapter) {
        this.transferTransactionAdapter = transferTransactionAdapter;
    }

    public void bookRegular(BankingTransaction paymentTransaction) {
        transferTransactionAdapter.send(paymentTransaction);
    }

    public void bookImmediate(BankingTransaction paymentTransaction) {
        validateTransaction(paymentTransaction);
        checkForHolidays(paymentTransaction);
        sendImmediately(paymentTransaction);
    }

    private void sendImmediately(BankingTransaction paymentTransaction) {
        transferTransactionAdapter.sendImmediate(paymentTransaction);
    }

    private void validateTransaction(BankingTransaction paymentTransaction) {

    }

    private void checkForHolidays(BankingTransaction paymentTransaction) {

    }

}
