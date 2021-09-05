package com.tinder.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private final String url = "jdbc:postgresql://ec2-34-249-247-7.eu-west-1.compute.amazonaws.com/ddfdl7e0fcj4ud";
    private final String user = "tfcbrwgpypjeoj";
    private final String password = "d38e123ccedb2f48b0f84b07488171af9a1d28f4a127590be82bf2450ad387e5";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
