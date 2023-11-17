package com.example.JavaReader;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@SpringBootApplication
public class JavaReaderApplication {
    public static void main(String[] args) throws IOException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "123456")) {
//            File file = new File("Account.xlsx");
            Workbook wb = new HSSFWorkbook();
            try (FileOutputStream accountFile = new FileOutputStream("Account.xls")) {
                Sheet sheet = wb.createSheet("account");
//header
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue(String.valueOf(AccountHeaders.ACCOUNT_NUMBER));
                headerRow.createCell(1).setCellValue(String.valueOf(AccountHeaders.ACCOUNT_TYPE));
                headerRow.createCell(2).setCellValue(String.valueOf(AccountHeaders.ACCOUNT_CUSTOMER_ID));
                headerRow.createCell(3).setCellValue(String.valueOf(AccountHeaders.ACCOUNT_LIMIT));
                headerRow.createCell(4).setCellValue(String.valueOf(AccountHeaders.ACCOUNT_OPEN_DATE));
                headerRow.createCell(5).setCellValue(String.valueOf(AccountHeaders.ACCOUNT_BALANCE));

//rows
//            for (int i = 1; i < 7; i++) {
                Row row = sheet.createRow(1);
//                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                row.createCell(0).setCellValue("123654");
                row.createCell(1).setCellValue("Type");
                row.createCell(2).setCellValue("123123123123");
                row.createCell(3).setCellValue(14020214);
                row.createCell(4).setCellValue("12");
                row.createCell(5).setCellValue("12555");
                ///
//            row = sheet.createRow(2);
////                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                row.createCell(0).setCellValue("741852");
                row.createCell(1).setCellValue("Type4");
                row.createCell(2).setCellValue("987");
                row.createCell(3).setCellValue(14);
                row.createCell(4).setCellValue("1");
                row.createCell(5).setCellValue("852");
//            }
                wb.write(accountFile);


//                customer
                FileOutputStream customerExcel = new FileOutputStream("Customer.xls");
                Workbook wb2 = new HSSFWorkbook();
                Sheet customerSheet = wb2.createSheet("Customer");
                Row headerRow1 = customerSheet.createRow(0);
                headerRow1.createCell(0).setCellValue("CUSTOMER_NAME");
                headerRow1.createCell(1).setCellValue("CUSTOMER_SURNAME");
                headerRow1.createCell(2).setCellValue("CUSTOMER_ADDRESS");
                headerRow1.createCell(3).setCellValue("CUSTOMER_ZIP_CODE");
                headerRow1.createCell(4).setCellValue("CUSTOMER_NATIONAL_ID");
                headerRow1.createCell(5).setCellValue("CUSTOMER_BIRTH_DATE");

                Row row1 = customerSheet.createRow(1);
                row1.createCell(0).setCellValue("مائده");
                row1.createCell(1).setCellValue("الماسی");
                row1.createCell(2).setCellValue("تهران");
                row1.createCell(3).setCellValue("1");
                row1.createCell(4).setCellValue("1234458547");
                row1.createCell(5).setCellValue(13750823);
                wb2.write(customerExcel);
                FileInputStream inputStream = new FileInputStream("Customer.xls");
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet1 = workbook.getSheetAt(0);
                for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
                    Row row2 = sheet1.getRow(i);
                    if (row2 != null) {
                        Cell CUSTOMER_NAME = row2.getCell(0);
                        Cell CUSTOMER_SURNAME = row2.getCell(1);
                        Cell CUSTOMER_ADDRESS = row2.getCell(2);
                        Cell CUSTOMER_ZIP_CODE = row2.getCell(3);
                        Cell CUSTOMER_NATIONAL_ID = row2.getCell(4);
                        Cell CUSTOMER_BIRTH_DATE = row2.getCell(5);

                        String sql = "INSERT INTO Customer(CUSTOMER_NAME,CUSTOMER_SURNAME,CUSTOMER_ADDRESS,CUSTOMER_ZIP_CODE,CUSTOMER_NATIONAL_ID,CUSTOMER_BIRTH_DATE)" +
                                "VALUES(?,?,?,?,?,?)";
//                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
//                        preparedStatement.setString(0,CUSTOMER_NAME);
//                        preparedStatement.setString(1,CUSTOMER_SURNAME);
//                        preparedStatement.setString(2,CUSTOMER_ADDRESS);
//                        preparedStatement.setString(3,CUSTOMER_ZIP_CODE);
//                        preparedStatement.setString(4,);
//                        preparedStatement.setString(5,);
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

//read method
            try (InputStream inp = new FileInputStream("Account.xls")) {
                Workbook wb2 = WorkbookFactory.create(inp);
                Sheet sheetAt = wb2.getSheetAt(0);
//                for (Row row : sheetAt) {
                for (int i = 1; i <= sheetAt.getLastRowNum(); i++) {
                    Row row = sheetAt.getRow(i);
                    if (row != null) {
                        String ACCOUNT_NUMBER = String.valueOf(row.getCell(0));
                        String ACCOUNT_TYPE = String.valueOf(row.getCell(1));
                        String ACCOUNT_LIMIT = String.valueOf(row.getCell(2));
                        int ACCOUNT_OPEN_DATE = (int) row.getCell(3).getNumericCellValue();
                        String ACCOUNT_CUSTOMER_ID = String.valueOf(row.getCell(4));
                        String ACCOUNT_BALANCE = String.valueOf(row.getCell(5));

                        String sql = "INSERT INTO ACCOUNT(ACCOUNT_NUMBER,ACCOUNT_TYPE,ACCOUNT_LIMIT,ACCOUNT_OPEN_DATE,ACCOUNT_CUSTOMER_ID,ACCOUNT_BALANCE)" +
                                "VALUES(?,?,?,?,?,?)";
                        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//                            stmt.executeUpdate("CREATE table ACCOUNT(id INTEGER NOT NULL AUTO_INCREMENT primary key ,ACCOUNT_NUMBER varchar(50),ACCOUNT_TYPE varchar(50), ACCOUNT_LIMIT varchar(50), ACCOUNT_OPEN_DATE varchar(255), ACCOUNT_CUSTOMER_ID INTEGER,ACCOUNT_BALANCE LONG)");
//                            stmt.executeUpdate("CREATE table Customer(id INTEGER NOT NULL AUTO_INCREMENT primary key ,CUSTOMER_NAME varchar(50),CUSTOMER_SURNAME varchar(50), CUSTOMER_ADDRESS varchar(50), CUSTOMER_ZIP_CODE varchar(255), CUSTOMER_NATIONAL_ID Long,CUSTOMER_BIRTH_DATE LONG)");

                            stmt.setString(1, ACCOUNT_NUMBER);
                            stmt.setString(2, ACCOUNT_TYPE);
                            stmt.setString(3, ACCOUNT_LIMIT);
                            stmt.setInt(4, ACCOUNT_OPEN_DATE);
                            stmt.setString(5, ACCOUNT_CUSTOMER_ID);
                            stmt.setString(6, ACCOUNT_BALANCE);
                            stmt.executeUpdate();
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
