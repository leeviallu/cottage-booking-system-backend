package org.example.cottagebookingsystembackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection() {
        //EnvironmentVariable.setEnvironmentVariables();
        String DB_URL = System.getProperty("DB_URL");
        String USER = System.getProperty("USER");
        String PASSWORD = System.getProperty("PASSWORD");

        try {
            // Load the JDBC driver (you may need to download and include the appropriate driver JAR file)
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
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

    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        // Use dbConnection.getConnection() to get the connection and execute queries
        // ...
        dbConnection.closeConnection();
    }
}

