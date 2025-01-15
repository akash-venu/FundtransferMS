package com.teckarch.FundTransferMS.Services.Interfaces;

import com.teckarch.FundTransferMS.Models.Transactions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transactions> getAllTransactions();
    Transactions initiatetransfers(Transactions fundTransfer);
    Optional<Transactions> getTransactionById(Long transferId);

}
