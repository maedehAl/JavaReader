package com.example.JavaReader;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SqlConn {
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                JdbcRowSet rowSet= RowSetProvider.newFactory().createJdbcRowSet();
//            } catch (ClassNotFoundException | SQLException e) {
//                throw new RuntimeException(e);
//            }

            HikariConfig hikariConfig = new HikariConfig();
            ResourceBundle bundle = ResourceBundle.getBundle("DB");
            hikariConfig.setJdbcUrl(bundle.getString("SQL_URL"));
            hikariConfig.setUsername(bundle.getString("USER"));
            hikariConfig.setPassword(bundle.getString("PASS"));
            dataSource = new HikariDataSource(hikariConfig);
        }
        return dataSource;
    }


}
