package com.example.JavaReader.service;

import com.example.JavaReader.dto.CreateRequestDto;
import com.example.JavaReader.entity.AccountEntity;
import com.example.JavaReader.repository.AccountRepository;
import com.example.JavaReader.repository.CustomerRepository;

public class BankCustomerServiceImpl implements BankCustomerService {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public BankCustomerServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public String create(CreateRequestDto createRequestDto) {

        AccountEntity accountEntity = new AccountEntity();


        accountEntity.getCustomerEntity().setCustomerName(createRequestDto.getCustomerName());
        accountEntity.getCustomerEntity().setCustomerSurname(createRequestDto.getCustomerSurname());
        accountEntity.getCustomerEntity().setCustomerAddress(createRequestDto.getCustomerAddress());
        accountEntity.getCustomerEntity().setCustomerNationalId(createRequestDto.getCustomerNationalId());
        accountRepository.save(accountEntity);
        return "done";
    }
}
