package com.unicorn.refactoring;

import java.math.BigDecimal;

public class ZagniezdzonyIfApplicationService {


    BigDecimal calculate(PaymentTransaction paymentTransaction){
        BigDecimal fee;
        if(paymentTransaction.isDebit()){
            fee = calculateDebitFee();
        }else {
            if(paymentTransaction.isSettled()){
                fee = calculateSettledTransactionFee();
            }else {
                if(paymentTransaction.isForeign()){
                    fee = calculateForeignFee();
                }else {
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
