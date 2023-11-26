package com.example.JavaReader;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDB {


    public ResultSet ReadFromDB(String query) throws SQLException {
        DataSource dataSource = SqlConn.getDataSource();
        Connection conn = dataSource.getConnection();
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        statement = conn.prepareStatement(query);
        resultSet = statement.executeQuery();
        return resultSet;
    }
}
