package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateJdbcExample {
    public static void main(String[] args) {

        try{
            //load jdbc driver
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "pratu@123");

            Statement stmt = conn.createStatement();

            String sql = "UPDATE customer set city = 'Wardha' where customer_id = 2000";
            int i = stmt.executeUpdate(sql);

            conn.close();
        }
        catch(Exception ex){
            ex.printStackTrace();

        }
    }
}
