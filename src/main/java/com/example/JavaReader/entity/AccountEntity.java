package com.example.JavaReader.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Table(schema = "ACCOUNT")
public class AccountEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "ACCOUNT_LIMIT")
    private String accountLimit;

    @Column(name = "ACCOUNT_OPEN_DATE")
    private String accountOpenDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_CUSTOMER_FK",referencedColumnName = "ID")
    private CustomerEntity customerEntity;

    @Column(name = "ACCOUNT_CUSTOMER_FK", insertable = false, updatable = false)
    private Long accountCustomerId;

    @Column(name = "ACCOUNT_BALANCE")
    private String accountBalance;

}
