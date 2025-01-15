package com.teckarch.FundTransferMS.Models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountsDto {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private String currency;
    private Double balance;
    private LocalDateTime createdAt;

}
