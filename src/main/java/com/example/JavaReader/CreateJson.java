package com.example.JavaReader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateJson {
    public void AccountJson() throws SQLException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ReadDB readDB = new ReadDB();
        ResultSet rst = readDB.ReadFromDB("select * from account");
        ArrayList<AccountDto> accountList = new ArrayList<>();
        while (rst.next()) {

            AccountDto accountDto1 = new AccountDto();
            accountDto1.setAccountNumber(rst.getString("ACCOUNT_NUMBER"));
            accountDto1.setAccountBalance(rst.getString("ACCOUNT_BALANCE"));
            accountDto1.setAccountCustomerId(rst.getString("ACCOUNT_CUSTOMER_ID"));
            accountDto1.setAccountLimit(rst.getString("ACCOUNT_LIMIT"));
            accountDto1.setAccountType(rst.getString("ACCOUNT_TYPE"));
            accountDto1.setAccountOpenDate(rst.getInt("ACCOUNT_OPEN_DATE"));

            accountList.add(accountDto1);

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("Account1.json"), accountList);
        }
    }
    }
