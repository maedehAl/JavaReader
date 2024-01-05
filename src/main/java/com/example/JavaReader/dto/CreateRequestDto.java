package com.example.JavaReader.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class CreateRequestDto implements Serializable {
    private int id;
    private String accountNumber;
    private String accountType;
    private String accountLimit;
    private String accountOpenDate;
    private int accountCustomerId;
    private String accountBalance;
    ///////////
    private String customerName;
    private String customerSurname;
    private String customerAddress;
    private String customerZipCode;
    private String customerNationalId;
    private String customerBirthDate;
}
