package com.unicorn.refactoring;

import java.math.BigDecimal;

public class BankingTransaction {

    private Money baseMoney;
    private Money localMoney;
    private BigDecimal fxRate;

    public BankingTransaction() {
    }

    public BankingTransaction(BigDecimal amount, String baseCurrency, String localCurrency) {
        localMoney = new Money(amount, localCurrency);
        baseMoney = new Money(null, baseCurrency);
        if (baseCurrency.equals(localCurrency)) {
            baseMoney.updateAmount(amount);
        }
    }

    public boolean isDebit() {
        return baseMoney.getAmount().compareTo(BigDecimal.ZERO) < 0;
    }

    public BigDecimal getFx() {
        return fxRate;
    }

    public BigDecimal getLocalAmount() {
        return localMoney.getAmount();
    }


    public String getLocalCurrency() {
        return localMoney.getCurrency();
    }

    public String getBaseCurrency() {
        return baseMoney.getCurrency();

    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseMoney.updateAmount(baseAmount);
    }

    public boolean isSettled() {
        return false;
    }

    public boolean isForeignExchange() {
        return false;
    }

    public BigDecimal getBaseAmount() {
        return baseMoney.getAmount();
    }

    private boolean isForeign() {
        return !getBaseCurrency().equals(getLocalCurrency())
                && getFx() == null;
    }

    private void calculateBaseAmount(BigDecimal fxRate) {
        BigDecimal bigDecimal = getLocalAmount().multiply(fxRate);
        setBaseAmount(bigDecimal);
    }

    void applyFx(BigDecimal fxRate) {
        if (isForeign()) {
            calculateBaseAmount(fxRate);
        }
    }
}
