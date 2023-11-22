package com.example.JavaReader;

import java.util.HashMap;

public class AccountDto {
    private String accountNumber;
    private String accountType;
    private String accountLimit;
    private int accountOpenDate;
    private String accountCustomerId;
    private String accountBalance;

    public HashMap<String, Integer> getSalary() {
        return salary;
    }

    public void setSalary(HashMap<String, Integer> salary) {
        this.salary = salary;
    }

    private HashMap<String,Integer> salary;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountLimit() {
        return accountLimit;
    }

    public void setAccountLimit(String accountLimit) {
        this.accountLimit = accountLimit;
    }

    public int getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(int accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    public String getAccountCustomerId() {
        return accountCustomerId;
    }

    public void setAccountCustomerId(String accountCustomerId) {
        this.accountCustomerId = accountCustomerId;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }


}
