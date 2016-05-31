package org.demo;

import java.sql.*;

public class DBConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/TestDB?useSSL=false";
    static final String USER = "root";
    static final String PASS = "root";
    static String sql = "";
    private static Connection conn = null;
     Statement stmt = null;


    public static Connection getConnection() {


        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void selectMethod() {
        try {
            stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                int value1 = rs.getInt("columnName1");
                String value2 = rs.getString("columnName2");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

}
