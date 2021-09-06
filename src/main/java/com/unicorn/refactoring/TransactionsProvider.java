package com.unicorn.refactoring;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsProvider {
    List<BankingTransaction> retrieveTransactions(LocalDate startDate, LocalDate endDate);
}
