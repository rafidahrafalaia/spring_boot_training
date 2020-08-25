package com.bcaf.ic.SpringTest.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdapterJDBC {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/bcafinance?serverTimezone=UTC";
    private static final String user="root";
    private static final String password ="Rahasia2";
    public static Connection getConnection(){
        Connection conn=null;
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
            System.out.println("Connected to mysql server successfull");
        } catch (SQLException e) {
            System.out.println("connection error");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
