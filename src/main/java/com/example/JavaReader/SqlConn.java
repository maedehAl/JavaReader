package com.example.JavaReader;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class SqlConn {
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
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
