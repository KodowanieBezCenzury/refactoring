package com.unicorn.refactoring;

import java.math.BigDecimal;

public class FxTransactionsApplicationService {

    public void applyFxRate(BankingTransaction paymentTransaction, BigDecimal fxRate) {
        if (!paymentTransaction.getBaseCurrency().equals(paymentTransaction.getLocalCurrency())
                && paymentTransaction.getFx() == null) {
            BigDecimal bigDecimal = paymentTransaction.getLocalAmount().multiply(fxRate);
            paymentTransaction.setBaseAmount(bigDecimal);
        }
    }

}
