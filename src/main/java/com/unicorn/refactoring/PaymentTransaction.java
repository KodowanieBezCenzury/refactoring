package com.unicorn.refactoring;

import java.math.BigDecimal;

public class PaymentTransaction {

    BigDecimal amount;

    public boolean isDebit() {
        return amount.compareTo(BigDecimal.ZERO) < 0;
    }
}
