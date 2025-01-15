package com.teckarch.FundTransferMS.Services;

import com.teckarch.FundTransferMS.Models.AccountsDto;
import com.teckarch.FundTransferMS.Models.Transactions;
import com.teckarch.FundTransferMS.Repository.TransactionRepository;
import com.teckarch.FundTransferMS.Services.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private  TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${accounts.ms.url}")
    String url;

    @Override
    public Transactions initiatetransfers(Transactions fundTransfer) {
       AccountsDto receiverAccount =  restTemplate.getForObject(url + "/" + fundTransfer.getReceiverAccountId(), AccountsDto.class);
       AccountsDto senderAccount =  restTemplate.getForObject(url + "/" + fundTransfer.getSenderAccountId(), AccountsDto.class);

        if (receiverAccount.getAccountNumber() == null || senderAccount.getAccountNumber() == null) {
            throw new RuntimeException("Invalid Account Number");
        }

        if (receiverAccount.getAccountNumber().equals(senderAccount.getAccountNumber())) {
            throw new RuntimeException("Self-transfers are not allowed");
        }

        receiverAccount.setBalance(
                BigDecimal.valueOf(receiverAccount.getBalance()).add(fundTransfer.getAmount()).doubleValue()
        );

        senderAccount.setBalance(
                BigDecimal.valueOf(senderAccount.getBalance()).subtract(fundTransfer.getAmount()).doubleValue()
        );

        restTemplate.put(url, senderAccount);
        restTemplate.put(url, receiverAccount);
       return transactionRepository.save(fundTransfer);
    }

    @Override
    public List<Transactions> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transactions> getTransactionById(Long transferId) {
        return transactionRepository.findById(transferId);
    }

}
