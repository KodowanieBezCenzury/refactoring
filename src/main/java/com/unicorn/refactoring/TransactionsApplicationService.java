package com.unicorn.refactoring;

import java.math.BigDecimal;

public class TransactionsApplicationService {

    //Dekompozycja instrukcji warunkowej.
    public void applyFxRate(BigDecimal fxRate, PaymentTransaction paymentTransaction){
        if (paymentTransaction.getBaseCurrency().equals(paymentTransaction.getLocalCurrency())
                && paymentTransaction.getFx() == null) {
            BigDecimal bigDecimal = paymentTransaction.getLocalAmount().multiply(fxRate);
            paymentTransaction.setBaseAmount(bigDecimal);
        }
    }

    //usuniecie parametru flagi
    //zamykamy w dwie osobne funkcje.
    //przeniesienie flagi do wewnatrz tranzakcji i w ten sposob upraszczamy API
    public void bookTransaction(PaymentTransaction paymentTransaction, boolean isPrioritized){

        if(isPrioritized){
            validateTransaction(paymentTransaction);
            checkForHolidays(paymentTransaction);
            sendImmediately(paymentTransaction);
        }else {
            send(paymentTransaction);
        }
    }

    private void sendImmediately(PaymentTransaction paymentTransaction) {

    }

    private void send(PaymentTransaction paymentTransaction) {

    }

    private void validateTransaction(PaymentTransaction paymentTransaction) {

    }

    private void checkForHolidays(PaymentTransaction paymentTransaction) {

    }

}
