package com.unicorn.refactoring;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TransactionsHistory {


    private TransactionsProvider transactionsProvider;

    public Map<String, Object> retrieveTransactions(Criteria criteria){
        LocalDate startDate = criteria.getStartDate();
        LocalDate endDate = criteria.endDate().plusDays(30);

        List<PaymentTransaction> onlineTransaction = transactionsProvider.retriveTransactions(startDate, endDate);

        Set<String> debitTransactions = onlineTransaction.stream()
                .filter(PaymentTransaction::isDebit)
                .map(debitTransaction -> new Gson().toJson(debitTransaction))
                .collect(Collectors.toSet());
        Map<String, Object> result = new HashMap<>();
        result.put("startDate", startDate);
        result.put("endDate", endDate);
        result.put("debitTransactions", debitTransactions);
        return result;
    }

}
