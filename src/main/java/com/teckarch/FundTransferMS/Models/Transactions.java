package com.teckarch.FundTransferMS.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transfer_id", unique = true, nullable = false)
    private Long transferId;

    @Column(name = "sender_account_id", nullable = false)
    private Long senderAccountId;

    @Column(name = "receiver_account_id", nullable = false)
    private Long receiverAccountId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    private String status;

//    @Column(name = "transaction_limit", nullable = false)
//    private BigDecimal transactionLimit;

    @CreationTimestamp
    private LocalDateTime initiatedAt;

    @UpdateTimestamp
    private LocalDateTime completedAt;

}
