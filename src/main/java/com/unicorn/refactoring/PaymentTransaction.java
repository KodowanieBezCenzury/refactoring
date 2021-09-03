package com.unicorn.refactoring;

import java.math.BigDecimal;

public class PaymentTransaction {

    private BigDecimal baseAmount;
    private BigDecimal localAmount;
    private BigDecimal fxRate;
    private String baseCurrency;
    private String localCurrency;

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

    public boolean isForeign() {
        return false;
    }
}
