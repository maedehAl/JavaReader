package com.example.JavaReader;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.sql.ResultSet;
import java.util.HashMap;


@SpringBootApplication
public class JavaReaderApplication {
    public static void main(String[] args) {



        CreateFiles createFiles = new CreateFiles();
        Insertion insertion = new Insertion();
        try {
            ObjectMapper mapper = new ObjectMapper();
            AccountDto accountDto = new AccountDto();
            accountDto.setAccountNumber("55785786767687");
            HashMap<String,Integer> salary=new HashMap<>();
            mapper.writeValue(new File("Account.json"),accountDto);
            String s = mapper.writeValueAsString(accountDto);
            System.out.println(s);
//
            createFiles.createAccount();
            insertion.insertAccount();

//                customer
            createFiles.createCustomer();
            insertion.insertCustomer();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rd", "root", "123456");
////             Statement stm= conn.createStatement();
////             stm.executeUpdate("INSERT INTO ACCOUNT(ACCOUNT_NUMBER,ACCOUNT_TYPE,ACCOUNT_LIMIT,ACCOUNT_OPEN_DATE,ACCOUNT_CUSTOMER_ID,ACCOUNT_BALANCE)VALUES ()");
//            // System.out.println(stm);
//            System.out.println(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//
//        } finally {
//
//        }
    }
}
