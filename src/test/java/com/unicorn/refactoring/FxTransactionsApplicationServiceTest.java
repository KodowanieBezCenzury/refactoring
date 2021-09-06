package com.unicorn.refactoring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

class FxTransactionsApplicationServiceTest {

    FxTransactionsApplicationService fxTransactionsApplicationService = new FxTransactionsApplicationService();

    @Test
    void shouldApplyFxRateWhenTransactionIsInLocalCurrency() {
        BankingTransaction paymentTransaction = givenTransactionInLocalCurrency();
        BigDecimal fxRate = valueOf(2);
        fxTransactionsApplicationService.applyFxRate(paymentTransaction, fxRate);
        thenFxRateIsApplied(paymentTransaction);
    }

    @Test
    void shouldNotApplyFxRateWhenTransactionIsInBaseCurrency() {
        BankingTransaction bankingTransaction = givenTransactionInBaseCurrency();
        BigDecimal fxRate = valueOf(4);
        fxTransactionsApplicationService.applyFxRate(bankingTransaction, fxRate);
        thenFxRateIsNotAppliedToBaseAmount(bankingTransaction);
    }

    private BankingTransaction givenTransactionInBaseCurrency() {
        BigDecimal baseAmount = valueOf(10);
        String baseCurrency = "USD";
        String localCurrency = "USD";
        return new BankingTransaction(baseAmount, baseCurrency, localCurrency);
    }

    private BankingTransaction givenTransactionInLocalCurrency() {
        String baseCurrency = "USD";
        String localCurrency = "EUR";
        BigDecimal localAmount = new BigDecimal(1);
        return new BankingTransaction(localAmount, baseCurrency,
                                      localCurrency);
    }

    private void thenFxRateIsNotAppliedToBaseAmount(BankingTransaction bankingTransaction) {
        BigDecimal expectedBaseAmountValue = valueOf(10);
        Assertions.assertThat(bankingTransaction.getBaseAmount()).isEqualTo(expectedBaseAmountValue);
    }

    private void thenFxRateIsApplied(BankingTransaction paymentTransaction) {
        BigDecimal expectedBaseAmount = valueOf(2);
        Assertions.assertThat(paymentTransaction.getBaseAmount()).isEqualTo(expectedBaseAmount);
    }

}