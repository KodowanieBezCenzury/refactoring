package com.unicorn.refactoring;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransactionsHistory {


    private final TransactionPeriod transactionPeriod = new TransactionPeriod();
    private TransactionsProvider transactionsProvider;

    public TransactionsHistory(TransactionsProvider transactionsProvider) {
        this.transactionsProvider = transactionsProvider;
    }

    public Map<String, Object> retrieveTransactions(Criteria criteria){
        DateRange dateRange = transactionPeriod.getDateRange(criteria);
        return calculateTransactions(dateRange);
    }

    private Map<String, Object> calculateTransactions(DateRange dateRange) {
        List<PaymentTransaction> onlineTransaction = transactionsProvider.retriveTransactions(dateRange.getStartDate(), dateRange.getEndDate());
        Set<String> debitTransactions = new Transactions(onlineTransaction).getDebitTransactions();
        Map<String, Object> result = new HashMap<>();
        result.put("startDate", dateRange.getStartDate());
        result.put("endDate", dateRange.getEndDate());
        result.put("debitTransactions", debitTransactions);
        return result;
    }

}
