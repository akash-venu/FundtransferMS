package com.teckarch.FundTransferMS.Controllers;

import com.teckarch.FundTransferMS.Models.Transactions;
import com.teckarch.FundTransferMS.Services.Interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<Transactions> initiateTransfer(@RequestBody Transactions transferFunds) {
        return new ResponseEntity<>(transactionService.initiatetransfers(transferFunds), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transactions>> getTransactionById(@PathVariable("id") Long transferId) {
        if (transferId != null) {
            return new ResponseEntity<>(transactionService.getTransactionById(transferId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
