package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection connect() throws ClassNotFoundException{
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "rootpassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}


