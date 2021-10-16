package com.unicorn.refactoring;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Money {

    private BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {

        this.amount = amount;
        this.currency = currency;
    }

    public void updateAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
