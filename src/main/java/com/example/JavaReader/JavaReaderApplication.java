package com.example.JavaReader;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;


@SpringBootApplication
public class JavaReaderApplication {
    public static void main(String[] args) throws IOException {
        File file = new File("Account.xlsx");
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
                row.createCell(3).setCellValue("12");
                row.createCell(4).setCellValue("14020214");
                row.createCell(5).setCellValue("12555");
                ///
            row = sheet.createRow(2);
//                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
            row.createCell(0).setCellValue("741852");
            row.createCell(1).setCellValue("Type4");
            row.createCell(2).setCellValue("987");
            row.createCell(3).setCellValue("14");
            row.createCell(4).setCellValue("14785");
            row.createCell(5).setCellValue("852");
//            }
            wb.write(accountFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//read method
        try (InputStream inp = new FileInputStream("Account.xls")) {
            Workbook wb2 = WorkbookFactory.create(inp);
            Sheet sheetAt = wb2.getSheetAt(0);
            Row row = null;
            Cell cell = null;
            for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
                row = sheetAt.getRow(i);
                for (int j=0;j<row.getLastCellNum();j++){
                    cell = row.getCell(i);
                    System.out.println(cell);
                }

            }


        }


//        Connection conn = null;
//        try {
//            Class.forName("org.mysql.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rd", "root", "123456");
//            // Statement stm= conn.createStatement();
//            // System.out.println(stm);
//            System.out.println(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//
//        }
//        finally {
//
//        }
    }
}
