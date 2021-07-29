package com.unicorn.refactoring;

import java.time.LocalDate;

public class TransactionPeriod {
    public TransactionPeriod() {
    }

    DateRange getDateRange(Criteria criteria) {
        LocalDate startDate = criteria.getStartDate();
        LocalDate endDate = criteria.endDate().plusDays(30);
        DateRange dateRange = new DateRange(startDate, endDate);
        return dateRange;
    }
}