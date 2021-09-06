package com.unicorn.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookingTransactionTest {

    @Mock
    TransferTransactionAdapter transferTransactionAdapter;

    @Test
    void shouldSendImmediateWhenFlagIsTrue() {
        BookingTransactionsApplicationService bookingTransactionsApplicationService = new BookingTransactionsApplicationService(transferTransactionAdapter);
        BankingTransaction transaction = new BankingTransaction();
        bookingTransactionsApplicationService.bookTransaction(transaction, true);
        Mockito.verify(transferTransactionAdapter, Mockito.times(1)).sendImmediate(ArgumentMatchers.any());
    }
}
