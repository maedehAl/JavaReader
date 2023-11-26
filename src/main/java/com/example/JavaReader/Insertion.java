package com.example.JavaReader;

import org.apache.poi.ss.usermodel.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insertion {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    public void insertAccount() {
        try (InputStream inp = new FileInputStream("Account.xls")) {
            DataSource dataSource = SqlConn.getDataSource();
            conn = dataSource.getConnection();

//            stmt.executeUpdate("CREATE table Customer(id INTEGER NOT NULL AUTO_INCREMENT primary key ,CUSTOMER_NAME varchar(50),CUSTOMER_SURNAME varchar(50), CUSTOMER_ADDRESS varchar(50), CUSTOMER_ZIP_CODE varchar(255), CUSTOMER_NATIONAL_ID Long,CUSTOMER_BIRTH_DATE varchar(255))");
//            stmt.executeUpdate("CREATE table ACCOUNT(id INTEGER NOT NULL AUTO_INCREMENT primary key ,ACCOUNT_NUMBER varchar(50),ACCOUNT_TYPE varchar(50), ACCOUNT_LIMIT varchar(50), ACCOUNT_OPEN_DATE varchar(255), ACCOUNT_CUSTOMER_ID INTEGER REFERENCES customer (id),ACCOUNT_BALANCE LONG)");


            Workbook wb2 = WorkbookFactory.create(inp);
            Sheet sheetAt = wb2.getSheetAt(0);
//                for (Row row : sheetAt) {
            final int batchSize = 5;
            int count = 0;

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
                    try {

//                            stmt.executeUpdate("CREATE table ACCOUNT(id INTEGER NOT NULL AUTO_INCREMENT primary key ,ACCOUNT_NUMBER varchar(50),ACCOUNT_TYPE varchar(50), ACCOUNT_LIMIT varchar(50), ACCOUNT_OPEN_DATE varchar(255), ACCOUNT_CUSTOMER_ID INTEGER REFERENCES customer (id),ACCOUNT_BALANCE LONG)");
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, ACCOUNT_NUMBER);
                        stmt.setString(2, ACCOUNT_TYPE);
                        stmt.setString(3, ACCOUNT_LIMIT);
                        stmt.setInt(4, ACCOUNT_OPEN_DATE);
                        stmt.setString(5, ACCOUNT_CUSTOMER_ID);
                        stmt.setString(6, ACCOUNT_BALANCE);
//                        stmt.executeUpdate();
                        stmt.addBatch();
                        if (++count % batchSize == 0) {
                            stmt.executeBatch();
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            stmt.executeBatch();
//            stmt.close();
//            conn.close();

        } catch (
                SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCustomer() {
        try {
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

                    //                    stmt.executeUpdate("ALTER TABLE account add FOREIGN KEY (ACCOUNT_CUSTOMER_ID) REFERENCES customer (id)");

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, String.valueOf(CUSTOMER_NAME));
                    preparedStatement.setString(2, String.valueOf(CUSTOMER_SURNAME));
                    preparedStatement.setString(3, String.valueOf(CUSTOMER_ADDRESS));
                    preparedStatement.setString(4, String.valueOf(CUSTOMER_ZIP_CODE));
                    preparedStatement.setString(5, String.valueOf(CUSTOMER_NATIONAL_ID));
                    preparedStatement.setString(6, String.valueOf(CUSTOMER_BIRTH_DATE));
                    preparedStatement.executeUpdate();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
