package com.example.skolead.Utils;

import java.sql.*;

public class SqlConnection {
    private Connection connection;
    private Statement stmt;

    public SqlConnection() {

        connection = null;
        stmt = null;


    }

    public Connection getConnection() {

        String url = "jdbc:mysql://localhost/skolead";
        String username = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return connection;
    }
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






