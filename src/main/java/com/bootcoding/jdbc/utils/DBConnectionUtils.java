package com.bootcoding.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtils {
    public static Connection getConnection(){
        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "pratu@123");
            return conn;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
