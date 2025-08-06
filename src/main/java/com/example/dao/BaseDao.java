package com.example.dao;



import java.sql.Connection;
import java.sql.DriverManager;


public abstract class BaseDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";

    protected Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }
}

