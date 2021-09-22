package com.unicorn.refactoring;

import java.math.BigDecimal;

public class FxTransactionsApplicationService {

    public void applyFxRate(BankingTransaction bankingTransaction, BigDecimal fxRate) {
        bankingTransaction.applyFx(fxRate);
    }

}
