package com.example.JavaReader;


import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JavaReaderApplication {
    public static void main(String[] args) {

        CreateFiles createFiles = new CreateFiles();
        Insertion insertion = new Insertion();
        try {

            createFiles.createAccount();
            insertion.insertAccount();

//                customer
            createFiles.createCustomer();
            insertion.insertCustomer();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
