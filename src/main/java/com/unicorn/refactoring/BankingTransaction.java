package com.unicorn.refactoring;

import java.math.BigDecimal;

public class BankingTransaction {

    private BigDecimal baseAmount;
    private String baseCurrency;
    private BigDecimal localAmount;
    private String localCurrency;
    private BigDecimal fxRate;

    public BankingTransaction() {
    }

    public BankingTransaction(BigDecimal amount, String baseCurrency, String localCurrency) {
        this.baseCurrency = baseCurrency;
        this.localCurrency = localCurrency;
        if (baseCurrency.equals(localCurrency)) {
            baseAmount = amount;
        }
        localAmount = amount;
    }

    public boolean isDebit() {
        return baseAmount.compareTo(BigDecimal.ZERO) < 0;
    }

    public BigDecimal getFx() {
        return fxRate;
    }

    public BigDecimal getLocalAmount() {
        return localAmount;
    }


    public Object getLocalCurrency() {
        return localCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;

    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public boolean isSettled() {
        return false;
    }

    public boolean isForeignExchange() {
        return false;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }
}
