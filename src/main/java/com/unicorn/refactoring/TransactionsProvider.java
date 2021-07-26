package com.unicorn.refactoring;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsProvider {
    List<PaymentTransaction> retriveTransactions(LocalDate startDate, LocalDate endDate);
}
