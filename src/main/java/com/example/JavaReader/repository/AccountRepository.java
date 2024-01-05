package com.example.JavaReader.repository;

import com.example.JavaReader.entity.AccountEntity;
import com.example.JavaReader.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Long> {
}
