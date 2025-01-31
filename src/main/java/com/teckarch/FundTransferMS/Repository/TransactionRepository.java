package com.teckarch.FundTransferMS.Repository;

import com.teckarch.FundTransferMS.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {


}
