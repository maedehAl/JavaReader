package com.example.JavaReader;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    @Expose(serialize = false, deserialize = false)
    private String accountNumber;
    private String accountType;
    private String accountLimit;
    private int accountOpenDate;
    private String accountCustomerId;
    private String accountBalance;
    private HashMap<String, Integer> salary;
}
