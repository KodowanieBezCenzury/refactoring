package com.unicorn.refactoring;

import java.math.BigDecimal;

public class FeeCalculationApplicationService {

    BigDecimal calculate(BankingTransaction paymentTransaction) {
        BigDecimal fee;
        if (paymentTransaction.isDebit()) {
            fee = calculateDebitFee();
        } else {
            if (paymentTransaction.isSettled()) {
                fee = calculateSettledTransactionFee();
            } else {
                if (paymentTransaction.isForeignExchange()) {
                    fee = calculateForeignFee();
                } else {
                    fee = calculateStandardFee();
                }
            }
        }
        return fee;
    }

    private BigDecimal calculateStandardFee() {
        return null;
    }

    private BigDecimal calculateForeignFee() {
        return null;
    }

    private BigDecimal calculateSettledTransactionFee() {
        return null;
    }

    private BigDecimal calculateDebitFee() {
        return null;
    }
}
