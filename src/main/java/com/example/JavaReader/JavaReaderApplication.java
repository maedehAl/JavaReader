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
