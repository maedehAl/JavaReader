package com.example.JavaReader.controller;

import com.example.JavaReader.dto.CreateRequestDto;
import com.example.JavaReader.service.BankCustomerService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

public class CustomerBankRestController {
private final BankCustomerService bankCustomerService;

    public CustomerBankRestController(BankCustomerService bankCustomerService) {
        this.bankCustomerService = bankCustomerService;
    }

//    @Mapping("/rest")
    @PostMapping("/create")
    public String create(CreateRequestDto createRequestDto){
    return bankCustomerService.create(createRequestDto);
}

}
