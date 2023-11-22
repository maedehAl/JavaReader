package com.example.JavaReader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFiles {
    public void createAccount() {
        Workbook wb = new HSSFWorkbook();
        try {
            FileOutputStream accountFile = new FileOutputStream("Account.xls");
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


            Row row = sheet.createRow(1);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCustomer() {
        try {
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
            row1.createCell(5).setCellValue("13750823");
            wb2.write(customerExcel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
