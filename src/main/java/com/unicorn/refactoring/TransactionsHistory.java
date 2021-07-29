package com.unicorn.refactoring;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TransactionsHistory {


    private final TransactionPeriod transactionPeriod = new TransactionPeriod();
    private TransactionsProvider transactionsProvider;

    public TransactionsHistory(TransactionsProvider transactionsProvider) {
        this.transactionsProvider = transactionsProvider;
    }

    public Map<String, Object> retrieveTransactions(Criteria criteria){
        DateRange dateRange = transactionPeriod.getDateRange(criteria);
        return calculateDateRange(dateRange);
    }

    private Map<String, Object> calculateDateRange(DateRange dateRange) {
        List<PaymentTransaction> onlineTransaction = transactionsProvider.retriveTransactions(dateRange.getStartDate(), dateRange.getEndDate());

        Set<String> debitTransactions = onlineTransaction.stream()
                .filter(PaymentTransaction::isDebit)
                .map(debitTransaction -> new Gson().toJson(debitTransaction))
                .collect(Collectors.toSet());
        Map<String, Object> result = new HashMap<>();
        result.put("startDate", dateRange.getStartDate());
        result.put("endDate", dateRange.getEndDate());
        result.put("debitTransactions", debitTransactions);
        return result;
    }

}
