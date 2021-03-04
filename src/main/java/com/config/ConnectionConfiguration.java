package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
    private static ConnectionConfiguration instance;

    private ConnectionConfiguration(){}

    public static ConnectionConfiguration getInstance(){
        if(instance == null){
            instance = new ConnectionConfiguration();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://samplepsql.cvit2io6ehiq.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=CarDealership",
                "josh",
                "password");
    }
}
