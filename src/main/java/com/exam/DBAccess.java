package com.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {

    private static Connection conn = null;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (conn == null) {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "123456");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
